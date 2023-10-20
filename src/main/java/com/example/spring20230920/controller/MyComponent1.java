package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class MyComponent1 {

    private final MyDao6 dao;

    @Transactional // 하나의 업무처리로 실행 시키고 싶을때에
    public void tx1() {
        dao.update1();
        //int c = 1/0; //runtimeException -> 강제로 exeption 을 발생시켜서 rollback시키게 하기
        dao.update2();

    }
}
