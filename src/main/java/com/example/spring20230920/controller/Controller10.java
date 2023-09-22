package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto10;
import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Controller10 {

    @RequestMapping("sub1")
    public void method1 (Model model) {
        MyDto9 o1 =new MyDto9();
        MyDto9 o2 = new MyDto9();

        o1.setFirstName("son");
        o2.setFirstName("lee");


        model.addAttribute("students", List.of(o1,o2));
        model.addAttribute("studentList",List.of(o1,o2,o1));
    }

    // Map과 bean을 사용
    @RequestMapping("sub2")
    public void method2(Model model) {
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();

        o1.setLastName("두식");
        o2.setLastName("봉석");

        model.addAttribute("personMap", Map.of("person1", o1,
                "person2",o2));

        model.addAttribute("people",
                Map.of("1st", o1 , "2nd", o2));

    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        MyDto10 o1 = new MyDto10();

        o1.setName("doosik");
        o1.setId(3);
        o1.setFoods(List.of("pizza","burger","milk"));
        o1.setCars(List.of("gm","kia","hd"));

        model.addAttribute("person1",o1);

    }

    @RequestMapping("sub4")
    public void method(Model model) {
        model.addAttribute("myList",List.of("tesala","kia","benz"));
    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        model.addAttribute("foodList", List.of(
           "피자", "커피","김치","라면","돈까스"
        ));

        model.addAttribute("names",List.of(
                "두식","봉석", "희수","미현"
        ));
    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        List<MyDto9> list = new ArrayList<>();
        list.add(new MyDto9("31","son","hm","football",111));
        list.add(new MyDto9("20","lee","ki","seoul",131));
        list.add(new MyDto9("32","kim","li","busan",122));
        list.add(new MyDto9("14","hong","ho","gimpo",123));
        list.add(new MyDto9("20","big","ki","mokpo",321));

        model.addAttribute("people", list);
    }




}
