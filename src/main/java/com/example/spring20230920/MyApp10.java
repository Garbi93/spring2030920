package com.example.spring20230920;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 다형성을 사용해서 작성 해보겠습니다.
public class MyApp10 {
}

interface MyInterface1 {

}

@Component
class MyClass18 implements MyInterface1 {

}

@Component
class MyClass19 implements MyInterface1{

}

@Component
//@RequiredArgsConstructor
class MyClass17 {
    private final MyInterface1 field;

    public MyClass17(@Qualifier("myClass18") MyInterface1 field) {
        // interface field에 주입될 클래스가 여러개라면 @Qualifier어노테이션을 붙여 명시해주어야 한다.
        this.field = field;
    }
}
