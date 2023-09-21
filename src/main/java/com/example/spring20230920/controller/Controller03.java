package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("main2")
public class Controller03 {
    // url 에 대한 설명
    // https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_URL

    // /main2/sub1?address=seoul
    @RequestMapping("sub1")
    public void method1(WebRequest request) {
        System.out.println("Controller03.method1");

        // query String 을 사용 해보기
        String address = request.getParameter("address");
        System.out.println("address = " + address);

    }

    // /main2/sub2?name=son&address=london
    @RequestMapping("sub2")
    public void method2(WebRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }


    // /main2/sub3?name=손흥민
    @RequestMapping("sub3")
    //이런식으로 바로 타입을 받아서 사용할 수도 있다.
    public void method3(@RequestParam("name") String name ) {
        System.out.println("name = " + name);
    }

    // /main2/sub4?name=김두식&address=서울
    @RequestMapping("sub4")
    // 여러 형식을 받아올때도 이런식으로 사용 가능
    public void method4(@RequestParam("name") String name,
                        @RequestParam("address") String address) {
        System.out.println("name = " + name);
        System.out.println("address = " + address);

    }

    // /main2/sub5?email=abc@gmail.com&gender=남자&number=010-9999
    // method5 작성
    @RequestMapping("sub5")
    public void method5(@RequestParam("email") String email,
                        @RequestParam("gender") String gender,
                        @RequestParam("number") String phone) {
        System.out.println("email = " + email);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);
    }


    // /main2/sub6?name=손&age=6
    @RequestMapping("sub6")
    public void method6(@RequestParam("name") String name,
                        @RequestParam("age") String age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        // 이것을 스프링이 해줬으면 좋겠다 -> method7
        Integer a= Integer.valueOf(age);
    }



    // /main2/sub7?name=손&age=42
    //main2/sub7?name=손&age=사십 을 넣으면  오류를 낼것이다. age를 Integer타입으로 받기 때문
    @RequestMapping("sub7")
    public void method7(@RequestParam("name") String name,
                        // @RequestParam을 쓸때 Integer 를 쓰면 자동으로 int탕입으로 부를 수 있다.
                        @RequestParam("age") Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }



    // /main2/sub8?address=seoul&married=false&age=66
    @RequestMapping("sub8")
    public void method8(@RequestParam("address") String address,
                        @RequestParam("married") boolean married,
                        @RequestParam("age") Integer age) {
        System.out.println("address = " + address);
        System.out.println("married = " + married);
        System.out.println("age = " + age);
    }


    // /main2/sub9?name=son
    @RequestMapping("sub9")
    // 리퀘스트 스트링을 안넣고 sub9을 호출 하고 싶을때 사용 하는 방법
    public void method9(@RequestParam(value = "name",required = false)String name) {
        System.out.println("name = " + name);
    }


    // /main2/sub10?address=seoul&age=30
    // /main2/sub10?address=jeju
    // 둘다 호출했을때 오류를 던지지 않고 사용할 수있게 method10 작성
    @RequestMapping("sub10")
    public void method10(@RequestParam("address") String address,
                         @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("address = " + address);
        System.out.println("age = " + age);
    }

    // /main2/sub11
    @RequestMapping("sub11")
    // defaultValue 는 required가 false여서 안넣으면 0을 출력한다.
    public void method11 (@RequestParam(value = "age", defaultValue = "0") Integer age) {
        System.out.println("age = " + age);
    }











}
