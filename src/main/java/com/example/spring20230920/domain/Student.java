package com.example.spring20230920.domain;

public class Student {
    // email property   (쓰기)
    // information property (읽기, 쓰기)getter,setter가 information이라서
    private String email;
    private String info;


    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformation() {
        return info;
    }

    public void setInformation(String info) {
        this.info = info;
    }
}
