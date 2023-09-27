package com.example.spring20230920.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main16")
public class Controller16 {
    @Autowired
    private ServletContext application;
    // 어플리케이션은 서블릿컨텍스트로 받는다
    // 어플리케이션은 세션보다 넓은 영역이다.

    @RequestMapping("sub1")
    public void method1(
            Model model, HttpSession session
    ) {
        model.addAttribute("modelAttr1","추석");
        session.setAttribute("sesstionAttr1","강강술래");
        application.setAttribute("appAttr1","보름달");
    }
}
