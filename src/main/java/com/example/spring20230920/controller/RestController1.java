package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao10;
import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto34customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@Controller
//@ResponseBody // 모든메소드에 적용됨
@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping("api/main1")
public class RestController1 {

    private final MyDao10 dao;

    // http://localhost:8080/api/main1/sub1
    @GetMapping("sub1")
    public String method1() {
        return "customer name";
    }

    // http://localhost:8080/api/main1/sub2
    // get 요청시
    // 5번 고객의 customerName 응답
    @GetMapping("sub2")
    public String method2( ) {
        return dao.FindCustomer();
    }

    @GetMapping("sub3")
    public MyDto34customer method3( ) {
        return dao.getCustomer();
    }

    // /api/main/sub4?id=33
    @GetMapping("sub4")
    public ResponseEntity<MyDto34customer> method4(String id) {
        MyDto34customer customer = dao.getCustomerById(id);
        if(customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }

    @GetMapping("sub5")
    public MyDto33Employee method (Integer id) {
        return dao.getEmployeeId(id);
    }

    @GetMapping("sub6")
    @ResponseBody
    public List<Integer> method6() {
        return dao.getCustomerIdList();
    }

    @GetMapping("sub7")
    public List<Integer> method7() {
        return dao.getEmployeeIdList();
    }


}









