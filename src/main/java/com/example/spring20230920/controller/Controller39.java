package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao8;
import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto45;
import com.example.spring20230920.service.MyService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("main39")
@RequiredArgsConstructor
public class Controller39 {

    private final MyDao8 dao;

    private final MyService2 service;

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
//        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("sub3")
    public ResponseEntity method3() {
        return ResponseEntity.status(501).build();
    }

    // /
    @GetMapping("sub4")
    @ResponseBody
    public ResponseEntity<MyDto45> method4(Integer id) {
        MyDto45 data = dao.selectByProductId2(id);

//        return ResponseEntity.status(200).body(data)
//        return ResponseEntity.ok().body(data);
//        return ResponseEntity.ok(data); // 3가지가 같은일을 함
        if(data == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(data);
        }
    }

    @GetMapping("sub5")
    public ResponseEntity method5() {
        if(Math.random() > 0.5) {
            return ResponseEntity.ok().build(); // 2xx
        }else {
            return ResponseEntity.internalServerError().build(); // 5xx
        }
    }

    @PostMapping("sub6")
    public ResponseEntity method6(@RequestBody MyDto33Employee dto) {
        if(service.validate(dto)) {
            int rows = service.add(dto);
            if(rows ==1) {
                return  ResponseEntity.ok().build();
            }else {
                return  ResponseEntity.internalServerError().build();
            }
        }else {
            return ResponseEntity.badRequest().build();
        }
    }



}
