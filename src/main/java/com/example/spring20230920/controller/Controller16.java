package com.example.spring20230920.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
        session.setAttribute("sessionAttr1","강강술래");
        application.setAttribute("appAttr1","보름달");

        model.addAttribute("attr1","송편");
        session.setAttribute("attr1","윳놀이");
        application.setAttribute("attr1","토끼");
    }

    @GetMapping("sub2")

    public void method2(
            HttpSession session
    ) {
        // 세션은 브라우저가 접속한 횟수만
        Object count = session.getAttribute("count");
        if(count == null) {
            session.setAttribute("count" , 0);
        }else {
            Integer countInt = (Integer)count;
            session.setAttribute("count", ++countInt);
        }

        // 어플리케이션이 세션보다 넓은 영역
        // 어플리케이션은 서버에 접속한 횟수
        Object appCount = application.getAttribute("count");
        if(appCount == null) {
            application.setAttribute("count",0);

        }else {
            Integer countInt=(Integer) count;
            countInt++;
            // 어플리케이션에 값을 넣는것은 서버가 시작하려 할때만 안정하디
            // 그러니깐 어플리케이션에 값을 넣는 용도로 사용하지말고 읽는 용도로만
            // 사용을 권장한다.
            application.setAttribute("count", countInt);
        }
    }

    @GetMapping("sub3")
    public void method3(
            Model model , HttpSession session
    ) {
        model.addAttribute("modelAttr1","보름달");
        // 모델은 해당 메소드에서만 작동하기 때문에 method4요청에서는 불러오면 못불러온다.
        session.setAttribute("sessionAttr1","송편");


        System.out.println("Controller16.method3");
        System.out.println("System.identityHashCode(model) = " + System.identityHashCode(model));
    }

    @GetMapping("sub4")
    public void method4(Model model, HttpSession session) {
        Object modelAttr1 = model.getAttribute("modelAttr1");
        Object sessionAttr1 = session.getAttribute("sessionAttr1");

        System.out.println("modelAttr1 = " + modelAttr1);
        System.out.println("sessionAttr1 = " + sessionAttr1);
    }

    @GetMapping("sub5")
    public String method5() {
        return "/main16/sub5"; // view name
    }

    @GetMapping("sub6")
    public String method6() {

        // redirection
        // 다른 곳(location)으로 가!!! 라는 응답(response, 3XX번대로 보통은 302번)
        return "redirect:/main16/sub5";
    }

    @GetMapping("sub7")
    public String method7() {
        return "redirect:https://www.naver.com";
    }

    @GetMapping("sub8")
    public String method8(String email) {

        String processed = email + "processed";

        return "redirect:/main16/sub9?p=" + processed;
    }

    @GetMapping("sub9")
    public void method9(String p) {
        System.out.println("p = " + p);
    }

    @GetMapping("sub10")
    public String method10 (String name, HttpSession session) {
        String processed = name + " 처리 결과";
        session.setAttribute("processedValue", processed);

        return "redirect:/main16/sub11";
    }

    @GetMapping("sub11")
    public void method11(HttpSession session) {
        Object processedValue = session.getAttribute("processedValue");
        System.out.println("processedValue = " + processedValue);
    }
    //세션을 직접 건들이는건 별로니깐
    // 리다이렉트로 쓰고 싶으면 아래와 같이 쓰자

    @GetMapping("sub12")
    public String method12 (String address, RedirectAttributes rttr) {
        String processed = address + " 처리 결과";
        // 세션을 사용하긴하는데 세션에 넣어놨다 두번째 요청이 일어난 직후
        // 세션에서 사라지고 모델에 들어간다.
        rttr.addFlashAttribute("processedValue", processed);
        return "redirect:/main16/sub13";

    }

    @GetMapping("sub13")
    public void method13(Model model) {
        // addFlashAttribute 한 것을 model에 넣어 사용 하기
        Object processed = model.getAttribute("processedValue");
        System.out.println("processed = " + processed);
    }

    // 첫 요청을 /main16/sub14
    @GetMapping("sub14")
    public String method14(RedirectAttributes rttr) {
        // /main16/sub15 요청할때
        // foodList 라는 attribute를 꺼낼 수 있게
        // 코드 작성
        rttr.addFlashAttribute("foodList",
                List.of("pizza","bugger","gamza","goguma"));
        return "redirect:/main16/sub15";
    }

    @GetMapping("sub15")
    public void method15(Model model) {
        Model foodList = model.addAttribute("foodList");
        System.out.println("foodList = " + foodList);
    }

    @GetMapping("sub16")
    public String method16(RedirectAttributes rttr) {
        rttr.addFlashAttribute("flashAttr","모델에 붙음");
        // addAttribute 는 쿼리 스트링에 붙는다.
        rttr.addAttribute("attr1","쿼리 스트링에 붙음");
        rttr.addAttribute("address","서울 신촌");

        return "redirect:/main16/sub17";
    }

    @GetMapping("sub17")
    public void method17() {
        System.out.println("Controller16.method17");
    }








}
