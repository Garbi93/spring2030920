package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("main4")
public class Controller04 {

    // /main4/sub1?name=son
    @RequestMapping("sub1")
    // 높은 확률 로 RequestParam 의 이름과 method 객체가 이름이 같으면
    // RequestParam의 value element 생략 가능
    public void method1 (@RequestParam String name) {
        System.out.println("name = " + name);
    }

    // /main4/sub2?address=seoule&email=avc@gamil.com&age=45
    @RequestMapping("sub2")
    public void method2(@RequestParam String address,
                        @RequestParam String email,
                        @RequestParam Integer age) {
        System.out.println("address = " + address);
        System.out.println("email = " + email);
        System.out.println("age = " + age);
    }


    // @RequestParam 생략하여서 사용도 가능하다
    // /main4/sub3?name=son&married=true
    // 단축 한곳에서는 requred가 true 가 아니기 때문에 주소창에 값을 안 넣어도 null로 출력 해준다.
    @RequestMapping("sub3")
    public void method3(String name, Boolean married) {
        System.out.println("name = " + name);
        System.out.println("married = " + married);
    }


    // /main4/sub4?check=true&email=abc@naver.com&age=55
    @RequestMapping("sub4")
    public void method4(Boolean check, String email, Integer age) {
        System.out.println("check = " + check);
        System.out.println("email = " + email);
        System.out.println("age = " + age);
    }












}
