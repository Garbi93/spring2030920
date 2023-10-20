package com.example.spring20230920.service;

import com.example.spring20230920.dao.MyDao6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 실제로 업무 하는 단위 를 service 라고 한다
//@Component
@Service
@RequiredArgsConstructor
public class MyService1 {


    private final MyDao6 dao;

    @Transactional // 하나의 업무처리로 실행 시키고 싶을때에
    public void tx1() {
        dao.update1();
        //int c = 1/0; //runtimeException -> 강제로 exeption 을 발생시켜서 rollback시키게 하기
        dao.update2();

    }
}
