package com.example.spring20230920.domain;

import lombok.Data;

import java.util.List;

@Data
public class MyDto11 {
    private String UserId;
    private String UserEmail;
    private String birthDate;
    private List<String> hobby;
}
