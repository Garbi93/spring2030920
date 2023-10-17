package com.example.spring20230920;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public class MyApp11 {

}

interface MyInterface2 {
    public void method2 ();
}
@Component
class MyClass22 implements MyInterface2 {
    public void method2() {} // 새로운 클래스를 생성해서 어노테이션을 옮겨주면 된다
    // 디펜던시를 쉽게 변경후 작업이 가능해진다.
}

//@Component
// 시간이 지나서 이 기능이 변경될 필요가 있을때 에
class MyClass21 implements MyInterface2 {
    public void method2 () {

    }
}
@Component
@RequiredArgsConstructor
class MyClass20 {
    private final MyInterface2 field;

    public void method20 () {
        field.method2();
    }
}
