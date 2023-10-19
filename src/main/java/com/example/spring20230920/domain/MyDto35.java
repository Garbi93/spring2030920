package com.example.spring20230920.domain;

import lombok.Getter;

public class MyDto35 {
    private String id;
    @Getter
    private String uRL;

    // 프로퍼티명 : id (get을 탈락시키고 앞글자를 소문자로 바꾼것)
    public String getId() {
        return id;
    }

//    public String getURL() { // 롬복에 의해서 URL로 완성될 것이다.
//        return uRL;
//    }
}
