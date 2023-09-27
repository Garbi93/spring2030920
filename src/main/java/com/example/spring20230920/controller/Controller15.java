package com.example.spring20230920.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {
    @GetMapping("sub1")
    public void method1() {

    }

    @GetMapping("sub2")
    public void method2(HttpServletRequest request, HttpSession session) {
        System.out.println();
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("session.getId() = " + session.getId());
        System.out.println();
    }

    @GetMapping("sub3")
    public void method3(
            @RequestParam(value = "name", defaultValue = "") String name,
            HttpSession session,
            HttpServletRequest request
    ) {
        if(!name.isBlank()) {
            session.setAttribute("username", name);
        }
        Object username = session.getAttribute("username");

        if (username != null){
            System.out.println();
            System.out.println("request = " + request.getRemoteHost());
            System.out.println("username = " + username);
            System.out.println();
        }
    }

    @GetMapping("sub4")
    public void method4() {

    }


    @PostMapping("sub5")
    // session 은 같은 브라우저에서 요청한 사항이라면
    // 다른 페이지에서 부르더라도 같은 session 의 내용을 불러올 수 있다.
    public void method5(
            String name, HttpSession session
    ) {
        session.setAttribute("username", name);
    }

    @GetMapping("sub6")
    public void method6() {}

    @GetMapping("sub7")
    public void method7() {

    }

    // post요청 /main15/sub8
    // request parameter foods 를
    // session 에 attribute로 넣고
    // sub8.jsp로 포워드 하는 메소드 만들기

    //get요청 /main15/sub9
    // sub9.jsp로 포워드 하는 메소드 만들기

    //단. sub8,jsp와 sub9.jsp에서는 sub7에서 선택한 음식들을 보여주기

    @PostMapping("sub8")
    public void method8(
            @RequestParam("foods") List<String> foods , HttpSession session
    ) {
        session.setAttribute("selectFood",foods);
    }

    @GetMapping("sub9")
    public void method9() {}

    // 모델과 세션에 저장한 모호한 상황
    @GetMapping("sub10")
    public void method10 (
            Model model , HttpSession session
    ) {
        model.addAttribute("modelAttr1","탕후루");
        session.setAttribute("sessionAttr1","마라탕");

        // 세션은 여러 요청(request)에서 사용되고
        // model은 한번의 요청(request)에서 사용된다

        // el에서 attribute에 접근하면 좁은 영역에서부터 찾는다
        //page < request(model) < session < application
        model.addAttribute("attr1", "돈까스");
        session.setAttribute("attr1","커피");
    }


    // sub11,jsp에서 두식,봉석 출력
    // 피자 햄버거 돈까스 출력
    @GetMapping("sub11")
    public void method11(
            Model model, HttpSession session
    ) {
        model.addAttribute("items", List.of("두식","봉석"));
        session.setAttribute("items",List.of("피자","햄버거","돈까스"));

    }





}
