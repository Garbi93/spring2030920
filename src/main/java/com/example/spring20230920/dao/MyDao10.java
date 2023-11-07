package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto34customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
