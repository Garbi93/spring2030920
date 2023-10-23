package com.example.spring20230920.service;

import com.example.spring20230920.dao.MyDao6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 실제로 업무 하는 단위 를 service 라고 한다
//@Component
@Service // 서비스 들은 하나의 업무 단위씩 작성 하니깐 class 단에 @Transactionl 어노테이션을 붙여주자
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class) // 하나의 업무처리로 실행 시키고 싶을때에
public class MyService1 {

    private final MyDao6 dao;

    //@Transactional(rollbackFor = Exception.class) // 하나의 업무처리로 실행 시키고 싶을때에
    // checkde Exception 에서도 rollback 을 일으키고 싶다면 -> rollbackFor = Exception.class 을 적어주자
    public void tx1() {
        dao.update1();
        int c = 1/0; //runtimeException -> 강제로 exeption 을 발생시켜서 rollback시키게 하기
        dao.update2();
    }
}
