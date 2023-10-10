package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("main23")
public class Controller23 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(String keyword) throws SQLException {
        String sql = """
                SELECT * FROM products
                WHERE productName LIKE ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"%"+ keyword +"%");
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet) {
            System.out.println();
            System.out.println( keyword +"가 포함된 상품명들");
            while (resultSet.next()){
                String name = resultSet.getString("productName");
                System.out.println("name = " + name);
            }

        }
    }

    // main23/sub2?k=erd
    // erd 라는 텍스트가 중간에 있는 고객명 조회
    @GetMapping("sub2")
    public void method2 (@RequestParam(value = "k", defaultValue = "") String keyword, Model model) throws SQLException {
        String sql = """
                SELECT * FROM customers
                WHERE CustomerName LIKE ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%"+keyword+"%");
        ResultSet resultSet = statement.executeQuery();

        List<String> list = new ArrayList<>();
        try(connection; statement; resultSet){
            System.out.println();
            System.out.println(keyword+" 가 포함된 고객 찾기");
            while (resultSet.next()){
               String name = resultSet.getString("customerName");
               System.out.println("고객 이름 : " + name);

               list.add(name);
            }
            model.addAttribute("keyword", keyword);
            model.addAttribute("nameList",list);
        }
    }

    // /main23/sub3?st=name1&k=red
    @GetMapping("sub3")
    public void method3(@RequestParam(value = "st",defaultValue = "name1") String searchType,
                        @RequestParam(value = "k",defaultValue = "") String keyword,
                        Model model) throws SQLException {
        String sql = """
                SELECT * FROM customers
                WHERE 
                """;

        if(searchType.equals("name1")){
            sql+="customerName LIKE ?";
        } else if (searchType.equals("name2")) {
            sql += "contactName LIKE ?";
        }

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"%"+keyword+"%");

        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        try(connection; statement; resultSet) {
            while (resultSet.next()){
                String customerName = resultSet.getString("customerName");
                String contactName = resultSet.getString("contactName");

                list.add(Map.of("customerName",customerName,"contactName",contactName));
            }

            model.addAttribute("searchType", searchType);
            model.addAttribute("keyword", keyword);
            model.addAttribute("customers",list);
        }

    }


    @GetMapping("sub4")
    public void method4(@RequestParam(value = "t",defaultValue = "lname") String searchType,
                        @RequestParam(value = "k", defaultValue = "") String inputKey,
                        Model model
    ) throws SQLException {
        String sql = """
                SELECT * FROM employees
                WHERE 
                """;
        if(searchType.equals("lname")) {
            sql += "lastName LIKE ?";
        } else if (searchType.equals("fname")) {
            sql += "firstName LIKE ?";
        } else if (searchType.equals("note")) {
            sql += "notes LIKE ?";
        }

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + inputKey + "%");
        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        try(connection; statement; resultSet) {
            while (resultSet.next()){
                String findLname = resultSet.getString("lastName");
                String findFname = resultSet.getString("firstName");
                String findNote = resultSet.getString("notes");

                list.add(Map.of("lastName", findLname,"firstName",findFname,"notes",findNote));

            }

            model.addAttribute("searchType",searchType);
            model.addAttribute("inputKey",inputKey);
            model.addAttribute("employeeList", list);
        }


    }




}
