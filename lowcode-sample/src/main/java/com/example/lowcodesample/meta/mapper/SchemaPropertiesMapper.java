package com.example.lowcodesample.meta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lowcodesample.meta.model.SchemaProperties;
import com.example.lowcodesample.core.lowcode.Entity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字段表(SchemaProperties)表持久层
 *
 * @author hrj
 * @since 2023-02-22 14:18:52
 */
@Mapper
public interface SchemaPropertiesMapper extends BaseMapper<SchemaProperties> {

    List<Entity.Properties> findList(String relationEntityId);
    
}

