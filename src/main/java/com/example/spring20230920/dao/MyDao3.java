package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Select("""
    SELECT DISTINCT Country FROM customers
    ORDER BY 1
    """)
    List<String> select5();


    @Select("""
    SELECT BirthDate FROM employees
    """)
    List<LocalDate> select6();


    @Select("""
    SELECT price FROM products
    ORDER BY Price
    """)
    List<Double> select7();

    @Select("""
    SELECT CustomerID,CustomerName,Address FROM customers
    WHERE CustomerID = 1
    """)
    Map<String, Object> select8();


    @Select("""
    SELECT p.ProductName, p.Price, c.CategoryName
    FROM products p JOIN categories c
    ON p.CategoryID = c.CategoryID
    WHERE p.ProductID = 1
    """)
    Map<String, Object> select9();

    @Select("""
        SELECT EmployeeID, LastName, FirstName 
        FROM employees
        WHERE EmployeeID = 1
        """)
    MyDto19 select10();

    @Select("""
        SELECT ProductName name, Price, CategoryName category
        FROM products p JOIN categories c 
        ON p.CategoryID = c.CategoryID
        WHERE ProductID = 1
        """)
    MyDto20 select11();


    @Select("""
        SELECT CustomerID id, CustomerName name, Country
        FROM customers
        WHERE CustomerID = 2
        """)
    MyDto21 select12();

    @Select("""
        SELECT ProductID id, ProductName name, Price
        FROM products
        WHERE CategoryID = 2
        ORDER BY Price;
        """)
    List<Map<String, Object>> select13();

    @Select("""
        SELECT ProductName name, Quantity, Price
        FROM orders o JOIN orderdetails od
        ON o.OrderID = od.OrderID
        JOIN products p
        ON od.ProductID = p.ProductID
        WHERE OrderDate = '1996-07-04'
    """)
    List<Map<String, Object>> select14();


    @Select("""
        SELECT ProductName name, Quantity, Price
        FROM orders o JOIN orderdetails od
        ON o.OrderID = od.OrderID
        JOIN products p
        ON od.ProductID = p.ProductID
        WHERE OrderDate = '1996-07-04'
    """)
    List<MyDto22> select15();

    @Select("""
        SELECT o.OrderDate `date`, p.ProductName pName, c.CategoryName cName, od.Quantity, p.Price
        FROM orderdetails od JOIN orders o
        ON od.OrderID = o.OrderID
        JOIN products p 
        ON p.ProductID = od.ProductID
        JOIN categories c
        ON p.CategoryID = c.CategoryID
        WHERE c.CategoryID = 1 
        ORDER BY `date`, pName
        """)
    List<MyDto23> select16();


    @Select("""
        SELECT CustomerName 
        FROM customers
        WHERE CustomerID = 100
        """)
    // 없는 것이 넘어가면???
    String select17();

    @Select("""
        SELECT CustomerID 
        FROM customers
        WHERE CustomerID = 100
        """)
    Integer select18();


    @Select("""
        SELECT CustomerID id,
                CustomerName name,
                Country
        FROM customers
        WHERE CustomerID = 1
        """)
    MyDto24 select19();

    @Select("""
        SELECT CustomerID id,
                CustomerName name,
                Country
        FROM customers
        WHERE CustomerID > 1
        """)
    MyDto24 select20();
}
