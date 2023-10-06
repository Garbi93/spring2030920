package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main22")
public class Controller22 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(Integer page) throws SQLException {

        String sql = """
                SELECT customerId id,
                       customerName name
                FROM customers
                ORDER BY id
                LIMIT ?, ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        //statement.setInt(1,0);  // 1페이지
        //statement.setInt(1,10);  // 2페이지
        //statement.setInt(1,20);  // 3페이지
        statement.setInt(1,(page-1)*10);
        statement.setInt(2,10);

        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");

                System.out.println(id + " : " +name);
            }
        }

    }


    // 페이지당 7개 씩 공급자 목록 조회(공급자 번호 순)
    // /main22/sub201 -> /main22/sub2?p=
    @GetMapping("sub201")
    public void method201(Model model) throws SQLException {
        String sql = """
                SELECT DISTINCT SupplierID
                FROM suppliers
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        List<Integer> list = new ArrayList<>();
        try(connection; statement; resultSet) {
            while (resultSet.next()){
                list.add(resultSet.getInt(1));
            }
        }
        model.addAttribute("p",list);

    }

    // 페이지당 7개 씩 공급자 목록 조회(공급자 번호 순)
    // /main22/sub2?p=2
    @GetMapping("sub2")
    public void method2(@RequestParam("p") Integer p, Model model) throws SQLException {
        String sql = """
                SELECT 
                    SupplierID id,
                    SupplierName name
                FROM suppliers
                ORDER BY SupplierID
                LIMIT ?, ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,(p-1)*7);
        statement.setInt(2,7);

        ResultSet resultSet = statement.executeQuery();
        //System.out.println("공급자 조회");
        List<Map<String, String>> list = new ArrayList<>();
        try(connection; statement; resultSet) {
            while (resultSet.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString("id"));
                map.put("name", resultSet.getString("name"));

                list.add(map);
                //-------------------------------------------------
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");

                System.out.println("번호 : " + id + " , 이름 : " + name);
                //-------------------------------------------------
            }
        }
        model.addAttribute("supplierList",list);
    }







}
