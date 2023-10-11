package com.example.spring20230920.controller;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("main25")
public class Controller25 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1 (@RequestParam(value = "id", required = false) Integer customerId) throws SQLException {
        if(customerId == null) {
            System.out.println("삭제할 id를 넣어주세요");
            return;
        }
        String sql = """
                DELETE FROM customers
                WHERE customerId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try(connection; statement) {
            statement.setInt(1, customerId);
            int rows =statement.executeUpdate();
            if (rows == 1) {
                System.out.println(rows + "개 레코드 잘 지워짐");
            }else {
                System.out.println("지워지지 않음");
            }
        }
    }

    @GetMapping("sub2")
    public void method2() {

    }

    @PostMapping("sub2")
    public void method211(@RequestParam("pid") Integer deleteId ) throws SQLException {
        if(deleteId == null ){
            System.out.println("삭제할 제품의 id 를 넣어주세요.");
        }
        String sql = """
                DELETE FROM products
                WHERE ProductID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try(connection; statement) {
            statement.setInt(1, deleteId);
            int rows = statement.executeUpdate();
            if(rows == 1 ) {
                System.out.println(rows + "의 데이터가 잘 삭제 되었습니다.");

            }else {
                System.out.println("데이터가 잘 삭제 되지 않았습니다.");
            }

        }

    }

    // update 연습
    @GetMapping("sub4")
    public void method4() throws SQLException {
        String sql = """
                UPDATE shippers
                SET shipperName =?,
                    phone = ?
                WHERE
                    shipperId = ?
                """;

        Connection connection =dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try(connection; statement) {
            statement.setString(1, "이강인");
            statement.setString(2, "01077778888");
            statement.setInt(3, 1);

            int rows = statement.executeUpdate();

            if(rows == 1) {
                System.out.println("잘 됨");
            }else {
                System.out.println("잘 못됨");
            }
        }


    }

    @GetMapping("sub5")
    public void method5(@RequestParam(value = "id", defaultValue = "1") Integer shipperId, Model model) throws SQLException {
        String sql = """
                SELECT * FROM shippers
                WHERE shipperId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setInt(1, shipperId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    model.addAttribute("shipper", Map.of("shipperId", resultSet.getInt("shipperId"),
                            "shipperName", resultSet.getString("shipperName"),
                            "phone", resultSet.getString("phone")));
                }

            }

        }

    }

    @PostMapping("sub5")
    public String method6(
            @RequestParam("id") Integer shipperId,
            @RequestParam("name") String shipperName,
            @RequestParam("phone") String phone,
            RedirectAttributes rttr
    ) throws SQLException {
        String sql = """
                UPDATE shippers
                SET shipperName = ?,
                    phone = ?
                WHERE
                    shipperId = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement) {
            statement.setString(1, shipperName);
            statement.setString(2, phone);
            statement.setInt(3, shipperId);

            int rows = statement.executeUpdate();

            if (rows == 1) {
                System.out.println("잘 변경됨");
            } else {
                System.out.println("문제 생김");
            }

        }

        rttr.addAttribute("id", shipperId);
        return "redirect:/main25/sub5";
    }


    @GetMapping("sub7")
    public void method7(@RequestParam(value = "id",defaultValue = "1") Integer employeeId, Model model) throws SQLException {
        String sql = """
                SELECT * FROM employees
                WHERE employeeId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();
            try (resultSet) {
                if (resultSet.next()) {
                    String lastName = resultSet.getString("lastName");
                    String firstName = resultSet.getString("firstName");

                    LocalDate birthDate = resultSet.getTimestamp("birthDate").toLocalDateTime().toLocalDate();
                    String photo = resultSet.getString("photo");
                    String notes = resultSet.getString("notes");

                    model.addAttribute("employee", Map.of(
                            "lastName", lastName,
                            "firstName", firstName,
                            "birthDate", birthDate,
                            "photo", photo,
                            "notes", notes,
                            "employeeId", employeeId
                    ));
                }
            }
        }

    }

    @PostMapping("sub7")
    public void method7 (
            @RequestParam("id") Integer employeeId,
            @RequestParam("lastName") String lastName,
            @RequestParam("firstName") String firstName,
            @RequestParam("birthDate") Date birthDate,
            @RequestParam("photo") String photo,
            @RequestParam("notes") String notes
    ) throws SQLException {
        String sql = """
                UPDATE employees
                SET 
                    LastName = ?,
                    FirstName = ?,
                    BirthDate = ?,
                    Photo = ?,
                    Notes = ?
                WHERE EmployeeID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setDate(3, birthDate);
            statement.setString(4, photo);
            statement.setString(5, notes);
            statement.setInt(6, employeeId);

            int rows = statement.executeUpdate();
            if(rows == 1) {
                System.out.println("변경이 잘 됨");
            }else  {
                System.out.println("잘못 됨");
            }
        }
    }


    //---------------------------------------------------------------------------------------
    // 리다이렉트 복습
    // Seestion으로 저장하는건 비교적 위험하지만
    // 저장 하고 싶을때는 addAttribut와 addFlashAttribute 를 사용하자.
    @GetMapping("sub9")
    public String method9 (RedirectAttributes rttr) {
        // Controller의 request handler 메소드의 리턴이
        // void (또는 null 리턴)이면 view 의 이름으로 해석

        // String 이면 view 의 이름으로 해석
        // "redirect:" 접두어가 붙으면
        // 응답코드가 302이고 location 응답헤더의 값이 접두어 이후의 값으로 셋팅

        // 쿼리스트링에 request parameter로 붙음
        rttr.addAttribute("abc","def");
        rttr.addAttribute("address","seoul");

        // 모델에 붙임 (session을 잠깐 거침)
        rttr.addFlashAttribute("email","abc@gmail.com");

        //return "redirect:https://www.naver.com"; // 네이버로 가는 응답
        return "redirect:/main25/sub10"; // 로컬데이터 에서 요청 하면
    }

    @GetMapping("sub10")
    public void method10 (Model model) {
        Object email = model.getAttribute("email");
        System.out.println("email = " + email);
        System.out.println("Controller25.method10");

    }
    //---------------------------------------------------------------------------------------





}
