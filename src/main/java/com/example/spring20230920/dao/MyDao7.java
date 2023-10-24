package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface MyDao7 {
    @Select("""
        SELECT * FROM customers
        WHERE CustomerID = #{id}
        """)
    Map<String, Object> selectByCustomerId(Integer id);


    @Select("""
        SELECT * FROM employees
        WHERE EmployeeID = #{id}
        """)
    Map<String, Object> selectByEmployeeId(Integer id);
}
