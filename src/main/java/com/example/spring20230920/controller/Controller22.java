package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

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
    // defaultValue
    @GetMapping("sub2")
    public void method2(@RequestParam(value = "p", defaultValue = "1") Integer p, Model model) throws SQLException {
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

        String sql1 = """
                SELECT COUNT(*)
                FROM suppliers
                """;
        Connection connection1 = dataSource.getConnection();
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);


        try(connection1; statement1; resultSet1) {
            if(resultSet1.next()){
                int countAll = resultSet1.getInt(1);

                // 마지막 페이지 번호
                int lastPageNumber = ((countAll -1) / 7 ) + 1;
                model.addAttribute("lastPageNumber", lastPageNumber);


            }
        }

        model.addAttribute("supplierList",list);
    }


    // /main22/sub3?p=2
    // 2페이지 고객목록 jsp에 테이블 형식 (id, name)출력
    // page 번호로 링크 만들기
    // 1페이지에 5개씩 출력
    @GetMapping("sub3")
    public void method3(@RequestParam(value = "p", defaultValue = "1") Integer p, Model model) throws SQLException {
        String sql = """
                SELECT CustomerID id, CustomerName name
                FROM customers
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, (p-1)*5);
        statement.setInt(2, 5);

        ResultSet resultSet = statement.executeQuery();

        List<Map<String, String>> list = new ArrayList<>();
        try(connection; statement; resultSet) {
            while (resultSet.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString("id"));
                map.put("name", resultSet.getString("name"));

                list.add(map);
            }
        }

        String sql1 = """
                SELECT COUNT(*)
                FROM customers
                """;

        Connection connection1 = dataSource.getConnection();
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);
                int lastNumber = 0;
        try(connection1; statement1; resultSet1) {
            if (resultSet1.next()){
                int countAll = resultSet1.getInt(1);

                lastNumber = ((countAll-1)/5) + 1;
                model.addAttribute("lastNumber",lastNumber);
            }
        }


        model.addAttribute("customerList",list);

        model.addAttribute("currentPage", p);

        int leftPageNumber = (p - 1)/ 5 * 5 +1;
        int rightPageNumber = leftPageNumber +4;

        rightPageNumber = Math.min(rightPageNumber, lastNumber);

        model.addAttribute("leftPageNumber", leftPageNumber);
        model.addAttribute("rightPageNumber", rightPageNumber);

//        int frontPageNumber=p;
//        int nextPageNumber=p;
//        if(frontPageNumber < lastNumber && frontPageNumber > 1 ){
//            frontPageNumber = p-1;
//        }
//        if(nextPageNumber < lastNumber && nextPageNumber > 1 ){
//            nextPageNumber = p+1;
//        }

        int frontPageNumber = leftPageNumber - 5;
        int nextPageNumber = rightPageNumber + 1;

        model.addAttribute("frontPageNumber",frontPageNumber);
        model.addAttribute("nextPageNumber", nextPageNumber);


    }





}
