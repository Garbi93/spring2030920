package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MyDao4 {

    @Select("""
        SELECT CustomerName
        FROM customers
        WHERE CustomerID = #{customerId}
        """)
    // 파라미터가 하나면 이름이 일치하지 않아도 됨
    // 하지만 걍 맞추자
    // 두개 이상이면 꼭 이름을 맞춰줘야한다!!!
    String select1(int customerId);


    @Select("""
        SELECT ProductName
        FROM products
        WHERE Price BETWEEN #{from} AND #{to}
        """)
    List<String> select2(Double from, Double to);

    @Select("""
        SELECT DISTINCT ProductName
        FROM products p JOIN orderdetails od
        ON p.ProductID = od.ProductID
        JOIN orders o
        ON o.OrderID = od.OrderID
        WHERE o.OrderDate BETWEEN #{from} AND #{to}
        order BY 1
        """)
    List<String> select3(LocalDate from, LocalDate to);

    @Select("""
        SELECT ProductName
        FROM products
        WHERE Price BETWEEN #{min} AND ${max}
        """)
    List<String> select4(MyDto25 dto);

    @Select("""
        SELECT CustomerName
        FROM customers
        WHERE Country = #{country1} OR Country = #{country2}
        """)
//    WHERE Country IN (#{country1} , #{country2})
    List<String> select5(MyDto26 dto);

    @Select("""
        SELECT COUNT(OrderID) 
        FROM orders
        WHERE OrderDate BETWEEN #{dto1.from} AND #{dto2.to}
        """)
    // 넘어온 자바빈이 2개 이상이면 자바빈 + 프로퍼티 네임 을 붙여 사용한다.
    Integer select6(MyDto27 dto1, MyDto28 dto2);

    @Select("""
        SELECT CustomerName
        FROM customers
        WHERE CustomerName LIKE #{dto2.keyword}
        LIMIT #{dto1.from},#{dto1.rows}
        """)

    List<String> select7(MyDto29 dto1,MyDto30 dto2);

    // Insert
    @Insert("""
        INSERT INTO customers(CustomerName, Country)
        VALUE (#{name},#{country})
        """)
    int insert1(MyDto31 dto); // executeUpdate 의 리턴 타입이 int라서

    @Insert("""
        INSERT INTO employees(LastName, FirstName)
        VALUE (#{lastName},#{firstName})
        """)
    int insert2(MyDto32 emp);


    // 10/9 delete
    @Delete("""
        DELETE FROM customers
        WHERE CustomerID = #{id}
        """)
    int delete1(Integer id);

    @Delete("""
        DELETE FROM products
        WHERE ProductID = #{pid}
        """)
    int delete2(Integer pid);


    @Select("""
        SELECT EmployeeID id, LastName, FirstName, BirthDate,Photo, Notes 
        FROM employees
        WHERE EmployeeID = #{id}
        """)
    MyDto33Employee select8(Integer id);

    @Update("""
        UPDATE employees
        SET LastName = #{lastName},
            FirstName = #{firstName},
            Photo = #{photo},
            Notes = #{notes},
            BirthDate = #{birthDate}
        WHERE EmployeeID = #{id}
        """)
    int update1(MyDto33Employee employee);

    @Select("""
        SELECT customerID id, 
        customerName, 
        contactName, 
        address,
        city,
        postalCode,
        country
        FROM customers
        WHERE CustomerID = #{id}
        """)
    MyDto34customer select9(Integer id);

    @Update("""
        UPDATE customers
        SET CustomerName = #{customerName},
            ContactName = #{contactName},
            Address = #{address},
            City = #{city},
            PostalCode = #{postalCode},
            Country = #{country}
        WHERE CustomerID = #{id}
        """)
    int update2(MyDto34customer customer);
}
