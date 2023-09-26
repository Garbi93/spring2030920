package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto11;
import com.example.spring20230920.domain.MyDto12;
import com.example.spring20230920.domain.MyDto13;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("main13")
public class Controller13 {

    @RequestMapping({
            "sub1",
            "sub2",
            "sub4",
            "sub7",
            "sub11",
            "sub13"
    })
    public void method1() {}

    @RequestMapping("sub3")
    public void method3(
            // 별일 없으면 상식선에서 타입을 맞춰주도록 하자
            @RequestParam(value = "param2", defaultValue = "0") Integer param2,
            @RequestParam("param1") String param1,
            @RequestParam("param3") String param3,
            @RequestParam(value = "param4", defaultValue = "2023-09-26") LocalDate param4,   // 날짜
            // 자바에서 날짜나 시간은 LocalDate로 읽는다.
            @RequestParam(value = "param5", defaultValue = "2023-09-26T11:50:30") LocalDateTime param5, // 날짜 시간
            @RequestParam("param6") String param6,
            @RequestParam(value = "param8", required = false) String[] param8, // 배열로 받을 수도 있다.
            @RequestParam("param8")List<String> param8tolist
            ) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
        System.out.println("param3 = " + param3);
        System.out.println("param4 = " + param4);
        System.out.println("param5 = " + param5);
        System.out.println("param6 = " + param6);
        //System.out.println("param8 = " + param8);
        if(param8 != null){
            Arrays.stream(param8).forEach(System.out::println);
        }

        System.out.println("리스트로 받음");
        param8tolist.forEach(System.out::println);
    }

    @RequestMapping("sub5")
    public void method5(
            @RequestParam("userId") String userId,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("birthDate") LocalDate birthDate,
            //@RequestParam("hobby") String hobby
            @RequestParam("hobby") List<String> hobby
    ) {
        System.out.println("아이디 : " + userId);
        System.out.println("이메일 : " + userEmail);
        System.out.println("생일 : " + birthDate);
        //System.out.println("취미 : " + hobby);
        hobby.forEach(System.out::println);
    }

    @RequestMapping("sub6")
    public void method6(MyDto11 user) {
        System.out.println("user = " + user);
    }

    @RequestMapping("sub8")
    public void method8(MyDto12 info) {
        System.out.println("info = " + info);
    }

    @RequestMapping("sub9")
    public void method9() {

    }
    @RequestMapping("sub10")
    public void method10(
            String title,
            String contentBody
    ) {
        System.out.println("title = " + title);
        System.out.println("contentBody = " + contentBody);
    }

    @RequestMapping("sub12")
    public void method12 (MyDto13 vo) {
        System.out.println("vo = " + vo);
    }

    @RequestMapping("sub14")
    public void method14(
            @RequestParam String hobby,
            @RequestParam List<String> food
    ) {
        System.out.println("hobby = " + hobby);
        System.out.println("food = " + food);
    }


}
