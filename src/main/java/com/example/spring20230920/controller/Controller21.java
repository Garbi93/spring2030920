package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping("main21")
public class Controller21 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws SQLException {
        // 쿼리문법 작성
        String sql = """
                SELECT customerName AS name,
                       country
                FROM customers
                WHERE CustomerID <= 3
                """;
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try(connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()){
                // 인덱스 번호로 출력도 가능하고
//                String name = resultSet.getString(1);
//                String country = resultSet.getString(2);

                // 퀀티티 네임으로 출력 가능하다.
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");

                System.out.println(name + " : " + country);
            }
        }

    }
    @GetMapping("sub2")
    public void method2() throws SQLException {
        String sql = """
                SELECT CONCAT(lastName, ', ', firstName) AS fullname,
                        BirthDate AS birth,
                        Notes AS `DESC`
                FROM employees
                """;
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try(connection; statement; resultSet) {
            System.out.println("직원의 생일과 이름");
            while (resultSet.next()){
                String name = resultSet.getString("fullname");
                String birth = resultSet.getString("birth");
                String desc = resultSet.getString("DESC");

                System.out.println("이름 : " + name + " , 생일 : " + birth + "," +desc);
            }
        }
    }











}
