package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao3;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("main29")
public class Controller29 {

    private final MyDao3 dao3;

    // 한행 한열
    @GetMapping("sub1")
    public void method1 () {
        String name = dao3.select1();
        System.out.println("name = " + name);
    }

    @GetMapping("sub2")
    public void method2() {
        Double price = dao3.select2();
        System.out.println("price = " + price);
    }

    @GetMapping("sub3")
    public void method3() {
        // 1번 직원의 lastName 조회 후 출력
        String EmployeeName = dao3.select3();
        System.out.println("EmployeeName = " + EmployeeName);
    }

    @GetMapping("sub4")
    public void method4() {
        // 2번 직원의 생일 조회후 출력
        LocalDate birthDate = dao3.select4();
        System.out.println("birthDate = " + birthDate);
    }

    // 여러행 1열
    @GetMapping("sub5")
    public void method5() {
        List<String> countrys = dao3.select5();
        countrys.forEach(System.out::println);
    }

    @GetMapping("sub6")
    public void method6 () {
        // 직원들의 생일 조회
        List<LocalDate> birth = dao3.select6();
        birth.forEach(System.out::println);
    }

    @GetMapping("sub7")
    public void method7 () {
        // 상품의 가격들 조회
        List<Double> priceList = dao3.select7();
        priceList.forEach(System.out::println);
    }

    // 하나행 여러열
    @GetMapping("sub8")
    public void method8 () {
        Map<String, Object> row = dao3.select8();
        System.out.println("row = " + row);
    }

    @GetMapping("sub9")
    public void method9 () {
        // 1번 상품의 상품명, 가격, 카테고리명
        Map<String, Object> row = dao3.select9();
        System.out.println("row = " + row);
        row.entrySet().forEach(System.out::println);
    }

    // 자바 빈 활용해보기
    @GetMapping("sub10")
    public void method10 () {
        MyDto19 dto = dao3.select10();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub11")
    public void method11() {
        MyDto20 dto = dao3.select11();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub12")
    public void method12() {
        MyDto21 dto = dao3.select12();
        // 2번 고객의 id, name, country 가 조회되도록
        // MyDto21의 property (id, name, country)
        System.out.println("dto = " + dto);
    }

    // 여러행 여러열
    @GetMapping("sub13")
    public void method13() {
        List<Map<String, Object>> rows = dao3.select13();
        for(Map<String, Object> row : rows){
            System.out.println("row = " + row);
        }
    }

    @GetMapping("sub14")
    public void method14() {
        // 1996년 7월 4일 에 주문된 상품명, 각 상품의 수량, 상품의 가격
        // orders, orderDetails, products
        List<Map<String, Object>> rows = dao3.select14();
        for (Map<String, Object>row : rows){
            System.out.println("row = " + row);
        }
        rows.forEach(System.out::println);
    }

    @GetMapping("sub15")
    public void method15() {
        // 1996년 7월 4일 에 주문된 상품명, 각 상품의 수량, 상품의 가격
        // orders, orderDetails, products
        List<MyDto22> rows = dao3.select15();
        rows.forEach(System.out::println);
    }

    // sub16 요청시
    // 1번 카테고리 상품들이 주문된 날짜, 상품명, 카테고리명, 수량, 가격
    @GetMapping("sub16")
    public void method16 () {
        List<MyDto23> dto = dao3.select16();
        dto.forEach(System.out::println);
        System.out.println(dto.size());
    }

    @GetMapping("sub17")
    public void method17 () {
        String s = dao3.select17();
        System.out.println("s = " + s);
        // null이 출력이 된다.
    }

    @GetMapping("sub18")
    public void method18 () {
        Integer i = dao3.select18();
        System.out.println("i = " + i);
        // 없는 int 값을 조회 하면 조회 할수 없다고 에러를 발생시킨다.
        // Integer 로 하면 null로 받아 반환 한다.
    }

    @GetMapping("sub19")
    public void method19 () {
        dao3.select19();
    }

    @GetMapping("sub20")
    public void method20() {
        MyDto24 myDto24 = dao3.select20();
        // 1행만 조회 할 수 있게 했는데 여러행을 조회 하게 시키면 에러를 발생시킨다.
        // but found: 90 이라는 에러 발생 -> 90개 가있다
    }
}
