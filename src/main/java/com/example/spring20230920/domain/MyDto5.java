package com.example.spring20230920.domain;

import lombok.*;

@NoArgsConstructor      // 파라미터가 없는 생성자를 생성한다 final값이 있으면 오류가 생긴다
@RequiredArgsConstructor    // 파이널 필드일때 생성자에서 값을 받도록 추가해준다
@AllArgsConstructor     // final이든 아니든 모든 값을 생성자의 값으로 받도록한다.
public class MyDto5 {
    private String name;
    private Integer age;


}

