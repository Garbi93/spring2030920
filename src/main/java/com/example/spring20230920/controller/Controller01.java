package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller     // 이게 컨트롤러라고 어노테이션으로 알리기
public class Controller01 {
    // 경로에 따라 일하는 맵핑 메소드를 알아봤다.

    // 평소에 만들던 클래스
    @RequestMapping("/")    // requsetMapping 어노테이션을 하면 스프링이 자동으로 실행해준다
    public void method1 () {
        System.out.println("Controller01.method1");
    }

    @RequestMapping("/path1")
    public void method2() {
        System.out.println("Controller01.method2");
    }

    // /path2  로 요청 왔을 때 일하는 메소드 작성
    @RequestMapping("/path2")
    public void method3 () {
        System.out.println("Controller01.method3");
    }
}
