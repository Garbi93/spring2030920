package com.example.spring20230920.domain;

import lombok.Data;

@Data
public class MyDto7 {

    private String email = "abc@gmail.com";
    private String address = "busan";

    public String getName() {
        return " 김봉석";
    }
    public Integer getAge() {
        return 31;
    }

    @Override
    public String toString() {
        return "내가 만든 클래스 😀";
    }
}
