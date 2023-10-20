package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao6;
import com.example.spring20230920.domain.MyDto37;
import com.example.spring20230920.domain.MyDto38;
import com.example.spring20230920.service.MyService1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("main32")
@RequiredArgsConstructor
public class Controller32 {
    private final MyDao6 dao;
    private final MyService1 service;

    @GetMapping("sub1")
    public void method1(MyDto37 dto) {
        dao.inset1(dto);

        System.out.println("dto = " + dto);
    }

    // /main32/sub2?lastName=흥민
    @GetMapping("sub2")
    public void method2(MyDto38 dto) {
        dao.inset2(dto); // 직원 테이블에 lastName 입력

        System.out.println("dto = " + dto); // 새 직원의 번호(pk)와 lastName출력
    }

    @GetMapping("sub3")
    public void method3() {

    }

    @PostMapping("sub4")
    public String method4(MyDto38 dto, RedirectAttributes rttr) {
        dao.insert3(dto);
        rttr.addFlashAttribute("message",dto.getId()+"번 직원이 등록되었습니다.");

        return "redirect:/main32/sub3";
    }


    // transaction 활용
    // 어노테이션에 작성한 의도대로 사용 하려면 같은 Bean 안에서 사용 하지 말고 밖에서 불러오는 방식으로 사용 하자
    @GetMapping("sub5")
    public void method5() {
        try{
            service.tx1(); // proxy를 거치지 않고 호출 하여서  transactional을 활용 안하고 바로 부르게 됨
        } finally {
            System.out.println("dao.select3 = " + dao.select3());
        }
    }









}
