package com.example.lowcodesample.online.mapper;

import com.example.lowcodesample.core.lowcode.Entity;
import com.example.lowcodesample.online.model.vo.SelectSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface OnlineMapper {
    
    @SelectProvider(type = OnlineSqlBuilder.class, method = "buildByParams")
    List<Map<String, Object>> selectList(@Param("selectSql") SelectSql selectSql, @Param("entity") Entity entity);
    
}
