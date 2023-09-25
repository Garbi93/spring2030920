package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto7;
import com.example.spring20230920.domain.MyDto8;
import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
@RequestMapping("main9")
public class Controller09 {
    @RequestMapping("sub1")
    public void method1 (Model model) {
        model.addAttribute("attr1","son");
        model.addAttribute("attr2",300);
        model.addAttribute("attr3",true);
        model.addAttribute("attr4",3.14);

        // 모델속성값이 배열일 경우
        model.addAttribute("attr5",new String[]{"lee","kim"});

        // 배열 변수를 속성값으로 불러올 경우
        String[] myArr1 = {"korea","seoul","jeju"};
        model.addAttribute("yourArr6",myArr1);
    }

    @RequestMapping("sub2")
    public void method2(Model model){
        String[] nameArr= {"손흥민", "이강인"};
        String[] emailArr = {"abc.gmail","afd@naver.com","afd@kakao.com"};
        String[] addressArr = {"seoul","busan"};

        model.addAttribute("myName",nameArr);
        model.addAttribute("yourEmail", emailArr);
        model.addAttribute("herAddress",addressArr);

    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        // 리스트도 인덱스로 값을 불러온다.
        model.addAttribute("names", List.of("두식","봉석","희수"));


        model.addAttribute("list1", List.of("삼성","LG","두산"));
        model.addAttribute("mapList",List.of("부산","서울","전주"));
        model.addAttribute("cities",List.of("뉴욕","파리","서울"));
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        // map을 model에 넣었을때
        var map1 = Map.of("son",7,"lee",19,"kim",30);
        model.addAttribute("myMap", map1);

        var map2 = Map.of("seoul","영등포","busan","깡통시장");
        var map3 = Map.of("red", "빨강", "blue","파랑","black","검정");

        model.addAttribute("cityMap",map2);
        model.addAttribute("color",map3);

        // 띄어쓰기나 - 가 허용이 안된다. 사용하려면 []안에 넣어 사용해야 한다.
        var map4 = Map.of(
                "name","두식",
                "my name", "봉석",
                "your-name", "희수"
        );
        model.addAttribute("attr3", map4);

    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        var map1 = Map.of("phone1","iphone","phone2","gelaxy");
        var map2 = Map.of("korea","seoul","us","ny");
        var map3 = Map.of("1st","hambuger","2nd","pizza");


        model.addAttribute("korea","us");
        model.addAttribute("phones",map1);
        model.addAttribute("caps",map2);
        model.addAttribute("foods",map3);
    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        model.addAttribute("attr1",new Object());
        model.addAttribute("attr2",new Scanner(System.in));
        model.addAttribute("attr3", new MyDto7());
    }


    @RequestMapping("sub7")
    public void method7(Model model) {
        MyDto8 o1 = new MyDto8();
        o1.setFood("pizza");
        o1.setComputer("intel");
        o1.setBirthDate("2020-01-01");

        model.addAttribute("person1", o1);
    }

    @RequestMapping("sub8")
    public void method8(Model model) {
        MyDto9 o1 = new MyDto9();
        o1.setId("no.01");
        o1.setFirstName("강인");
        o1.setLastName("이");
        o1.setClassName("햇님반");
        o1.setPhoneNumber(11112222);

        model.addAttribute("student",o1);
    }
}

