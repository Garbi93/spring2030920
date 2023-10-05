package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto15;
import com.example.spring20230920.domain.MyDto16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main19")
public class Controller19 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String method1(Model model) throws Exception {
        String sql = """
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = 3
            """;


        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try(connection; statement; resultSet) {
            resultSet.next();
            String name = resultSet.getString(1);
            model.addAttribute("customerName", name);
        }

        return "/main18/sub1";
    }

    @GetMapping("sub2")
    public void method1 () throws Exception{
        String sql = """
                SELECT *
                FROM shippers
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try(connection; statement; resultSet) {
            boolean next1 = resultSet.next();
            resultSet.getString(1); // "1"
            resultSet.getString(2); // "Speedy Express"
            resultSet.getString(3); // "(503) 555-9931"

            boolean next2 = resultSet.next();
            resultSet.getString(1); // "2"
            resultSet.getString(2); // "United Package"
            resultSet.getString(3); // "(503) 555-3199"
            boolean next3 = resultSet.next();
            resultSet.getString(1); // "3"
            resultSet.getString(2); // "Federal Shipping"
            resultSet.getString(3); // "(503) 555-9931"

            boolean next4 = resultSet.next();

            System.out.println("next1 = " + next1);
            System.out.println("next2 = " + next2);
            System.out.println("next3 = " + next3);
            System.out.println("next4 = " + next4);
        }

    }

    @GetMapping("sub3")
    public void method3(Model model) throws Exception{
        List<Map<String, String>> list = new ArrayList<>();

        String sql = """
                SELECT *
                FROM shippers
                """;
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        try (connection; statement; resultSet){
            while (resultSet.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString(1));
                map.put("name", resultSet.getString(2));
                map.put("phone", resultSet.getString(3));

                list.add(map);
            }
        }
        model.addAttribute("shippers", list);
    }

    @GetMapping("sub4")
    public void method4(Model model) throws Exception{
        // /main19/sub4.jsp 작성

        String sql = """
                SELECT CustomerID, CustomerName, City, Country
                FROM customers
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Map<String, String>> list = new ArrayList<>();
        try (connection; statement; resultSet){
            while (resultSet.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id" , resultSet.getString(1));
                map.put("name" , resultSet.getString(2));
                map.put("city" , resultSet.getString(3));
                map.put("country" , resultSet.getString(4));

                list.add(map);
            }
        }
        model.addAttribute("customers", list);
    }

    @GetMapping("sub5")
    public void method5(Model model) throws Exception{
        String sql = """
                SELECT ProductID, ProductName,Unit, Price
                FROM products
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Map<String, String>> list = new ArrayList<>();

        try(connection; statement; resultSet) {
            // 코드 작성
            while (resultSet.next()){
                Map<String, String> map = new HashMap<>();
                map.put("pid", resultSet.getString(1));
                map.put("productName", resultSet.getString(2));
                map.put("unit", resultSet.getString(3));
                map.put("price", resultSet.getString(4));

                list.add(map);
            }
        }
        // 코드 작성
        model.addAttribute("productList", list);

    }

    // 자바빈을 사용하여 만들어보기
    @GetMapping("sub6")
    public void method6(Model model ) throws Exception{
        String sql = """
                SELECT CustomerID, CustomerName, Address, Country
                FROM customers
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<MyDto15> list = new ArrayList();
        try (connection; statement; resultSet) {
            while(resultSet.next()) {
                MyDto15 dto = new MyDto15();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setAddress(resultSet.getString(3));
                dto.setCountry(resultSet.getString(4));

                list.add(dto);
            }
        }
        model.addAttribute("customerList", list);
    }

    @GetMapping("sub7")
    public String method7(Model model) throws Exception {
        String sql = """
                SELECT ProductID, ProductName, Unit, Price
                FROM products
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<MyDto16> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                MyDto16 dto = new MyDto16();
                dto.setPid(resultSet.getInt(1));
                dto.setProductName(resultSet.getString(2));
                dto.setUnit(resultSet.getString(3));
                dto.setPrice(resultSet.getString(4));

                list.add(dto);
            }
        }

        model.addAttribute("productList", list);
        return "/main19/sub5";
    }

    @GetMapping("sub8")
    public void method8() {
        // jsp 로 forward
    }

    @GetMapping("sub9")
    public String method9(Integer pid , Model model) throws Exception {
        // 쿼리 작성
        String sql = """
                SELECT ProductID, ProductName, Unit, Price
                FROM products
                WHERE ProductID = 
                """;
        sql += pid;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        List<MyDto16> list = new ArrayList<>();
        // 쿼리 실행
        ResultSet resultSet = statement.executeQuery(sql);
        try(connection; statement; resultSet) {
            // 실행 결과 처리
            while (resultSet.next()) {
                MyDto16 dto = new MyDto16();
                dto.setPid(resultSet.getInt(1));
                dto.setProductName(resultSet.getString(2));
                dto.setUnit(resultSet.getString(3));
                dto.setPrice(resultSet.getString(4));

                list.add(dto);
            }

        }
        // 처리한 결과 모델에 넣기
        model.addAttribute("productList", list);

        // 적절한 view로 포워드
        return "/main19/sub5";

    }

    // sub10, sub11 id별 조회
    @GetMapping("sub10")
    public void method10() {

    }

    @GetMapping("sub11")
    public String method11(Integer cid, Model model) throws Exception {
        //쿼리 작성(method6참고)
        String sql = """
                SELECT CustomerID, CustomerName, Address, Country
                FROM customers
                WHERE CustomerID = 
                """;
        sql += cid;

        // 쿼리 실행
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<MyDto15> list = new ArrayList<>();

        // 실행 결과 처리(method6참고), MyDto15 사용
        try(connection; statement; resultSet) {
            while (resultSet.next()) {
                MyDto15 dto = new MyDto15();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setAddress(resultSet.getString(3));
                dto.setCountry(resultSet.getString(4));

                list.add(dto);
            }
        }
        // 처리한 결과 model에 attribute로 넣고
        model.addAttribute("customerList", list);
        //view 로 forword
        return "/main19/sub6";
    }

    // sub12 , sub13 국가별 조회
    @GetMapping("sub12")
    public void method12(Model model) throws SQLException {
        String sql = """
                SELECT DISTINCT country
                FROM customers
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<String> list = new ArrayList<>();

        try(connection; statement; resultSet){
            while (resultSet.next()){
                String country = resultSet.getString(1);

                list.add(country);
            }
        }
            model.addAttribute("countryList",list);
    }

    @GetMapping("sub13")
    public String method13(String country, Model model) throws SQLException {
        String sql = """
                SELECT CustomerID, CustomerName, Address, Country
                FROM customers
                WHERE Country = '""" + country + "'";

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<MyDto15> list = new ArrayList<>();

        // 실행 결과 처리(method6참고), MyDto15 사용
        try(connection; statement; resultSet) {
            while (resultSet.next()) {
                MyDto15 dto = new MyDto15();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setAddress(resultSet.getString(3));
                dto.setCountry(resultSet.getString(4));

                list.add(dto);
            }
        }
        // 처리한 결과 model에 attribute로 넣고
        model.addAttribute("customerList", list);
        //view 로 forword
        return "/main19/sub6";
    }










}
