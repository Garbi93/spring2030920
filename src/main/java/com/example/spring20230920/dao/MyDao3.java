package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

@Mapper
public interface MyDao3 {
    @Select("""
    SELECT CustomerName FROM customers
    WHERE CustomerID = 1
    """)

    String select1(); // select타입으로 반환 해주면 된다.

    @Select("""
    SELECT Price FROM products
    WHERE ProductID = 1
    """)
    Double select2();

    @Select("""
    SELECT LastName FROM employees
    WHERE EmployeeID = 1;
    """)
    String select3();

    @Select("""
    SELECT BirthDate FROM employees
    WHERE EmployeeID = 2
    """)
    LocalDate select4();
}
