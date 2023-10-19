package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyDao5 {
    @Select("""
        <script>
            SELECT count(*) 
            FROM customers
            
            <if test='country !=null'>
            WHERE Country = #{country}
            </if>
        </script>
    """)
    String selec1(String country);
}
