package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto37;
import com.example.spring20230920.domain.MyDto38;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MyDao6 {

    @Insert("""
        INSERT INTO customers(CustomerName)
        VALUE (#{name})
        """)
    @Options(useGeneratedKeys = true, keyProperty = "id")  // 자동으로 증가하는 key를 지정해주는 어노테이션
    int inset1(MyDto37 dto);

    @Insert("""
        INSERT INTO employees(LastName)
        VALUE (#{lastName})
        """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int inset2(MyDto38 dto);
}
