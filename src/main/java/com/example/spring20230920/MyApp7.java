package com.example.spring20230920;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

// Autowired 를 사용 한것
@SpringBootApplication
public class MyApp7 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp7.class, args);

        System.out.println(context.getBean("myClass12"));
        System.out.println(context.getBean("myClass11", MyClass11.class).getDep());
    }
}
@Component
class MyClass12 {

}

@Component
class MyClass11 {
    private MyClass12 dep;

    public MyClass11() {
    }

    @Autowired // 생성자 주입
    public MyClass11(MyClass12 dep) {
        this.dep = dep;
    }

    public MyClass12 getDep() {
        return dep;
    }
}

// Autowired 생성자가 하나라면 autowired를 생략가능하다