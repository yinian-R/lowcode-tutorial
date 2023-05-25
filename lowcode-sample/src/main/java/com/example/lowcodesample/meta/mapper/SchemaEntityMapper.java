package com.example.lowcodesample.meta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lowcodesample.meta.model.SchemaEntity;
import com.example.lowcodesample.core.lowcode.Entity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 实体表(SchemaEntity)表持久层
 *
 * @author hrj
 * @since 2023-02-22 14:18:52
 */
@Mapper
public interface SchemaEntityMapper extends BaseMapper<SchemaEntity> {

    List<Entity> findList();
    
    Entity find(String id);
    
    Entity findByName(String name);
    
}

