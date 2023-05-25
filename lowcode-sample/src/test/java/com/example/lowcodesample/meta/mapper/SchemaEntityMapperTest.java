package com.example.lowcodesample.meta.mapper;

import com.example.lowcodesample.core.lowcode.Entity;
import com.example.lowcodesample.meta.model.SchemaEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SchemaEntityMapperTest {
    
    @Autowired
    private SchemaEntityMapper schemaEntityMapper;
    @Autowired
    private SchemaPropertiesMapper schemaPropertiesMapper;
    @Autowired
    private SchemaIndexesMapper schemaIndexesMapper;
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    void test() {
    
    }
    
    /**
     * 通过编码获取封装对象
     */
    @Test
    void findList1() {
        List<SchemaEntity> list = schemaEntityMapper.selectList(null);
        for (SchemaEntity schemaEntity : list) {
            List<Entity.Properties> properties = schemaPropertiesMapper.findList(schemaEntity.getId());
    
            System.out.println(properties);
    
            List<Entity.Index> indices = schemaIndexesMapper.findList(schemaEntity.getId());
    
            System.out.println(indices);
        }
    }
    
    /**
     * 使用 mybatis resultMap 返回封装对象
     */
    @Test
    void findList2() throws JsonProcessingException {
        List<Entity> list = schemaEntityMapper.findList();
        System.out.println(objectMapper.writeValueAsString(list));
    }
    
}