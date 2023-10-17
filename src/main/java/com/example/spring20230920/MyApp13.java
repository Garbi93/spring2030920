package com.example.spring20230920;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

// 스프링 bean이 갖을 수 있는 annotation
@SpringBootApplication
public class MyApp13 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp13.class, args);

    }
}
@Component
class MyClass26 {

//    @PostConstruct // DI 완료 후 바로 실행
    // postConstruct 사용 이유 ->
    // 의존성 주입을 해주고 초기화 하는것 웹 어플리케이션이 실행 될 때에 자동으로 실행 될 수 있게 해주는 어노테이션이다.
    // 예를 들어 DB에 연결하는 설정이 있는 코드라면 어플리케이션이 실행됨과 동시에 실행 되어야 하니깐 이때 postConstruct 어노트이션을 사용한다.
    public void method1() {
        System.out.println("MyClass26.method1");
    }
}
