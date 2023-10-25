package com.example.spring20230920.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main39")
@RequiredArgsConstructor
public class Controller39 {

    @GetMapping("sub0")
    public void method0() {

    }

    @GetMapping("sub1")
    @ResponseBody // ResponseEntity 를 사용 할때 쓰는 어노테이션 이지만 ResponseEnetitiy타입으로 반환하면 생략하고 사용 가능하다.
    public ResponseEntity method1() {
        // ResponseEntity
        // : 응답코드, 응답본문 작성 가능한 객체

        return ResponseEntity.status(500).build();
    }

    @GetMapping("sub2")
    public ResponseEntity method2() {
        return  ResponseEntity.notFound().build(); // 404에러 내보내는 메소드 .notFound()
    }


}
