package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao6;
import com.example.spring20230920.domain.MyDto37;
import com.example.spring20230920.domain.MyDto38;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main32")
@RequiredArgsConstructor
public class Controller32 {
    private final MyDao6 dao;

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
}
