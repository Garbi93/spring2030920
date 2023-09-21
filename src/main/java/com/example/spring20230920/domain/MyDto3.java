package com.example.spring20230920.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 클래스에 설정하면 모든 멤버변수에 생성됨
@Getter
@Setter
@ToString
public class MyDto3 {
    // getter 가 생성됨 lombok으로
    @Getter
    // setter 가 생성됨 lombok으로
    @Setter
    private String name;

    @Getter
    @Setter
    private String address;
}
