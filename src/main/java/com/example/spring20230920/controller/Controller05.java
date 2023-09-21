package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main5")
public class Controller05 {

    // /main5/sub1?name=lee&age=30&address=seoul
    // params를 사용 해서 값이 없으면 오류를 던지게 만들기
    @RequestMapping(value = "sub1", params = {"name","age"})
    public void method1(String name, Integer age, String address) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
    }



    // /main5/sub2?name=lee&age=30&address=busan
    @RequestMapping("sub2")
    public void method2(String name, Integer age, String address) {
        // 외부에서 클래스를 불러와 객체를 사용하는 경우도 있는데
        // 이런것을 스프링이 해줬으면 좋겠다 는 sub3에서 이어서
        Person5 o1 = new Person5();
        o1.setName(name);
        o1.setAge(age);
        o1.setAddress(address);

        System.out.println(o1);

        // service.action(o1);
    }

    // /main5/sub3?name=lee&age=30&address=busan
    @RequestMapping("sub3")
    // 스프링이 method3의 객체 타입을 외부클래스로 받아오면 자동적으로 다 받아 올수 있게 해준다.
    public void method3(Person5 person5) {
        System.out.println("person5 = " + person5);
    }

    // /main5/sub4?email=ab@gmail.com&married=true&age=23&info=programmer
    // method4작성
    // class = Student5 작성
    @RequestMapping("sub4")
    public void method4(Student5 s) {
        System.out.println("Student5의 속성들은 : " + s);
    }




}

class Student5 {
    private String email;
    private Boolean married;
    private Integer age;
    private String info;

    public String getEmail() {
        return email;
    }

    public Boolean getMarried() {
        return married;
    }

    public Integer getAge() {
        return age;
    }

    public String getInfo() {
        return info;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student5{" +
                "email='" + email + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }
}

class Person5 {
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person5{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}