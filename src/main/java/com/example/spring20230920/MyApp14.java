package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@SpringBootApplication
public class MyApp14 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp14.class, args);
        Object myBean1 = context.getBean("myBean1");
        System.out.println("myBean1 = " + myBean1);
        Object myBean2 = context.getBean("myBean2");
        System.out.println("myBean2 = " + myBean2);

        Configuration1 conf = context.getBean("configuration1", Configuration1.class);
        MyClass27 obj1 = conf.myBean1();
        MyClass27 obj2 = conf.myBean2();

        System.out.println("obj1 = " + obj1);
        System.out.println("obj2 = " + obj2);
    }

}

// Configuration 클래스(빈) :
// spring bean을 만드는 메소드를 가진 클래스
// 내가 만들것이 아닌 이미 만들어진 어떠한 코드를 갖고 올때 bean으로 만들어 사용 하고 싶을때에 configuration을 사용합니다.

@Configuration
class Configuration1 {

    // 빈을 만드는 메소드
    // bean의 이름은 메소드명과 같음
    @Bean
    public MyClass27 myBean1 () {
        return new MyClass27();
    }


    @Bean
    public MyClass27 myBean2() {
        return new MyClass27();
    }
}

// @Component // 우리가 만든것은 붙여줄 수 있다.. // 빈의 이름이 클래스 이름을 lowerCamelCase로 바꾼 것
class MyClass27 {

}
