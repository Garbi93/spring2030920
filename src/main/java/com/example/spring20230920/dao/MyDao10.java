package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto34customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao10 {
    @Select("""
        SELECT CustomerName FROM customers
        WHERE CustomerID = 4
        """)
    String FindCustomer();

    @Select("""
        SELECT CustomerID id,
         CustomerName,
          contactname, address, city, postalcode, country
         FROM customers
        WHERE CustomerID = 50
        """)
    MyDto34customer getCustomer();

    @Select("""
        SELECT CustomerID id,
         CustomerName,
          contactname, address, city, postalcode, country
         FROM customers
        WHERE CustomerID = #{id}
    """)
    MyDto34customer getCustomerById(String id);


    @Select("""
        SELECT EmployeeID id,
         LastName, 
         FirstName, 
         Photo,
         Notes,
         BirthDate 
        FROM employees
        WHERE EmployeeID = #{id}
    """)
    MyDto33Employee getEmployeeId(Integer id);

    @Select("""
        SELECT CustomerID FROM customers
        ORDER BY CustomerID
        """)
    List<Integer> getCustomerIdList();
}
