package com.example.lowcodesample.meta.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableManageMapper {
   
    @Insert("${sql}")
    void exec(String sql);
    
}
