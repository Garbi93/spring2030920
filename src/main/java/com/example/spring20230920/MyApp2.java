package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp2 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp2.class, args); // 스프링부트 어플리케이션을 실행시키는 방법
                                                                                // 이렇게 작성하면 필요한 인스턴스를 우리가 작성한 클래스로 자동으로 생성해준다.

        Object bean1 = context.getBean("myInstance2");      // spring bean
        System.out.println(bean1 instanceof MyClass2); // true
        MyClass2 o1 = (MyClass2) bean1;
        o1.method2();

        Object bean3 = context.getBean("myBean3");      // spring bean
        System.out.println(bean3 instanceof MyClass3); // true
        MyClass3 o2 = (MyClass3) bean3;

        System.out.println(System.identityHashCode(context.getBean("myBean3")));
        System.out.println(System.identityHashCode(context.getBean("myBean3")));
        System.out.println(System.identityHashCode(context.getBean("myBean3")));
        System.out.println();

        System.out.println(System.identityHashCode(context.getBean("myInstance2")));
        System.out.println(System.identityHashCode(context.getBean("myInstance2")));
        System.out.println(System.identityHashCode(context.getBean("myInstance2")));
        System.out.println();

        MyClass2 bean22 = context.getBean("myInstance2", MyClass2.class);
        MyClass3 bean33 = context.getBean("myBean3", MyClass3.class);

        System.out.println(System.identityHashCode(bean22));
        System.out.println(System.identityHashCode(bean33));

    }
}

@Component("myBean3")
class MyClass3 {

}

@Component("myInstance2")   // 메인메소드가 있는 클래스에 패키지와 그 하위 패키지를 탕색해서 @Component 가 붙은 클래스 를 인스턴스로 자동생성 해준다.
class MyClass2 {
    public void method2 () {
        System.out.println("MyClass2.method2");
    }
}
