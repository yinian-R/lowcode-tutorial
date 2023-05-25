package com.example.lowcodesample.meta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lowcodesample.meta.model.SchemaIndexes;
import com.example.lowcodesample.core.lowcode.Entity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 索引表(SchemaIndexes)表持久层
 *
 * @author hrj
 * @since 2023-02-22 14:18:52
 */
@Mapper
public interface SchemaIndexesMapper extends BaseMapper<SchemaIndexes> {

    List<Entity.Index> findList(String relationEntityId);
    
}

