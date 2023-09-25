package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto6;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main8")
public class Controller08 {

    @RequestMapping("sub1")
    public void method01 (Model model){
        // model 임포트 하기 스프링이 해줌
        model.addAttribute("attr1","value1");
        model.addAttribute("attr2","velue2");

        // forward to -> /WEB-INF/jsp/main8/sub1.jsp
    }

    @RequestMapping("sub2")
    public void method2(Model model, MyDto6 c) {
        model.addAttribute("propone","😊");
        model.addAttribute("propTWO","😎");
        System.out.println(c);
        model.addAttribute("name",c.getName());

    }

    // 9/22일 시작 부분
    @RequestMapping("sub3")
    public void method3(Model model) {
        // wiew name : /main8/sub3
        // 실제 jsp경로 -> /WEB-INF/jsp/main8/sub3.jsp

        model.addAttribute("myName","Lee");
        model.addAttribute("yourAddress","seoul");
        model.addAttribute("herEmail","abc@gmail.com");
        //System.out.println("Controller08.method3");
    }



}
