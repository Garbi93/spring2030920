package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto37;
import com.example.spring20230920.domain.MyDto38;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Insert("""
        INSERT INTO employees(LastName, FirstName)
        VALUE (#{lastName},#{firstName})
        """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert3(MyDto38 dto);

    // 업데이트 활용
    @Update("""
        UPDATE w3schools.bank
        SET money = money -1000
        WHERE name = 'son'
        """)
    int update1();

    @Update("""
        UPDATE w3schools.bank
        SET money = money +1000
        WHERE name = 'kim'
        """)
    int update2(); // Update는 변경된 row의 갯수를 반환 하기 때문에 int 타입으로 반환 시킨다.


    @Select("""
        SELECT *
        FROM w3schools.bank
        ORDER BY name
        """)
    List<Map<String, Object>> select3();
}
