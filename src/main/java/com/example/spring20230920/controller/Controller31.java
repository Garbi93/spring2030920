package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao5;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main31")
@RequiredArgsConstructor
public class Controller31 {
    private final MyDao5 dao;

    @GetMapping("sub1")
    public void method1() {
        String res1 = dao.selec1("Mexico"); // 맥시코 고객만
        System.out.println("res1 = " + res1);

        String res2 = dao.selec1(null); // 전체 고객조회
        System.out.println("res2 = " + res2);
    }
}
