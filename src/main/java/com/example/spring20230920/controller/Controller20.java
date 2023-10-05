package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto15;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main20")
public class Controller20 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1 () {

    }

    // preparedStatement 를 사용하여 sql 공격을 막는 법
    @GetMapping("sub2")
    public String method2(String id, Model model) throws Exception{
        //쿼리 작성(method6참고)
        String sql = """
                SELECT CustomerID, CustomerName, Address, Country
                FROM customers
                WHERE CustomerID = ?
                """;

        // 쿼리 실행
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
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


    @GetMapping("sub3")
    public void method3(String id) throws SQLException {
        String sql = """
                SELECT customerId, customerName, country
                FROM customers
                WHERE customerId = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id);
//        statement.setInt(1, 3);

        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet) {
            while (resultSet.next()) {
                System.out.println("고객정보");
                System.out.println("id = " + resultSet.getString(1));
                System.out.println("name = " + resultSet.getString(2));
            }

        }
    }

    // /main20/sub4?pid=5
    @GetMapping("sub4")
    public void method4(Integer pid) throws SQLException {
        String sql = """
                SELECT productId, productName
                FROM products
                WHERE ProductID = ?
                """;
        Connection connection = dataSource.getConnection();
        // preparedStatement 를 사용 한다 이때 sql변수를 여기에 넣어줘야 한다.
        // prepared로 sql문을 컴파일하고
        PreparedStatement statement = connection.prepareStatement(sql);
        // set타입을 저장 하여 where의 인덱스와 받아오는 값의 변수를 넣고
        // ?를 채우고
        statement.setInt(1, pid);

        // 기존 statement와 동일하게 executeQuery 로 저장 시켜준다
        ResultSet resultSet = statement.executeQuery();
        try(connection; statement; resultSet) {
            while (resultSet.next()) {
                System.out.println();
                System.out.println("상품 정보");
                System.out.println("상품번호 = " + resultSet.getInt(1));
                System.out.println("상품명 = " + resultSet.getString(2));
            }

        }

    }
    // /main20/sub5?country=spain
    // 콘솔에 spain에 사는 고객 이름 출력
    @GetMapping("sub5")
    public void method5(String country) throws SQLException {
        String sql = """
                SELECT Country, CustomerID, CustomerName 
                FROM customers
                WHERE Country = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet) {
            while (resultSet.next()){
                System.out.println();
                System.out.println("고객 정보");
                System.out.println("나라 = " + resultSet.getString(1));
                System.out.println("고객 번호 = " + resultSet.getString(2));
                System.out.println("고객 이름 = " + resultSet.getString(3));

            }
        }

    }

    @GetMapping("sub6")
    public void method6(String c1, String c2) throws SQLException {
        String sql = """
                SELECT customerName, country
                FROM customers
                WHERE country =? OR country = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, c1); // 물음표 의 위치 앞
        statement.setString(2, c2); // 물음표 의 위치 뒤
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet) {
            System.out.println();
            System.out.println("고객 목록");
            while (resultSet.next()){
                String country = resultSet.getString(2);
                String name = resultSet.getString(1);
                System.out.println(country + ":" + name);
            }
        }
    }



    @GetMapping("sub7")
    public void method7() {

    }

    @GetMapping("sub8")
    public void method8(Integer min, Integer max, Model model) throws SQLException {
        String sql = """
                SELECT ProductName, Price
                FROM products
                WHERE Price >= ? AND Price <= ? 
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, min);
        statement.setInt(2, max);
        ResultSet resultSet = statement.executeQuery();

        List<Map<String, String>> list = new ArrayList<>();
        try (connection; statement; resultSet){
            while (resultSet.next()){
                Map<String, String> map = new HashMap();
                map.put("pName",resultSet.getString(1));
                map.put("price",resultSet.getString(2));

                list.add(map);
            }

        }
        model.addAttribute("productList", list);
    }









}
