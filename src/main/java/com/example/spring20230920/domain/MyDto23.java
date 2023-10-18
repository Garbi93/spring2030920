package com.example.spring20230920.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MyDto23 {
    private LocalDate date;
    private String pName;
    private String cName;
    private Integer Quantity;
    private Double Price;
}
