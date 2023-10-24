package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
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

    @Insert("""
        INSERT INTO employees(LastName, FirstName, BirthDate)
        VALUES (#{lastName},#{firstName},#{birthDate})
        """)
    int insertEmployee(String lastName, String firstName, LocalDate birthDate);

    @Insert("""
        INSERT INTO products(ProductName,Price, CategoryID)
        VALUES (#{name},#{price},#{category})
        """)
    int insertProduct(String name, Double price, Integer category);

    @Delete("""
        DELETE FROM products
        WHERE ProductID = #{pid}
        """)
    int deleteByProductId(Integer pid);

    @Delete("""
        DELETE FROM customers
        WHERE CustomerID = #{cid}
        """)
    int deleteByCustomerId(Integer cid);
}
