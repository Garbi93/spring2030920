package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main7")
public class Controller07 {

    // RequestMapping Handler Method -> 줄여서 Handler Method라고 한다.

    @RequestMapping("sub1")
    public String method1() {
        System.out.println("Controller07.method1");

        // spring 이 jsp의 위치를 찾아 보여준다
        return "view1";
    }

    @RequestMapping("sub2")
    public String method2() {
        System.out.println("Controller07.method2");

        return "html2";
        // /WEB-INF/jsp/---.jsp
        // ---부분만 잘 만들어서 리턴하면 된다.
    }

    // void return : 요청경로가 view name 이됨
    // 요청 경로 : /main7/sub3
    // view name : /main7/sub3
    // 실제 jsp 경로 : /WEB-INF/jsp/main7/sub3.jsp
    @RequestMapping("sub3")
    public void method3() {
        System.out.println("Controller07.method3");
    }

    // /WEB-INF/jsp/main7/html4.jsp
    @RequestMapping("sub4")
    public String method4() {
        System.out.println("main7 폴더 안에서 String 타입으로 호출");
        return "/main7/html4";
    }


    // /WEB-INF/jsp/main7/sub5.jsp
    @RequestMapping("sub5")
    public void method5() {
        System.out.println("main7폴더 안의 sub5를 잘 호출함");
    }


}
