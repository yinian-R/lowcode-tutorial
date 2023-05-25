package com.example.lowcodesample.meta.tool.schema;

import com.example.lowcodesample.core.lowcode.Entity;
import com.example.lowcodesample.meta.mapper.SchemaEntityMapper;
import com.example.lowcodesample.meta.mapper.SchemaIndexesMapper;
import com.example.lowcodesample.meta.mapper.SchemaPropertiesMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TableExporterTest {
    
    @Autowired
    private SchemaEntityMapper schemaEntityMapper;
    @Autowired
    private SchemaPropertiesMapper schemaPropertiesMapper;
    @Autowired
    private SchemaIndexesMapper schemaIndexesMapper;
    @Autowired
    private ObjectMapper objectMapper;
    
    
    @Test
    void getSqlCreateStrings() {
        for (Entity entity : schemaEntityMapper.findList()) {
            TableExporter exporter = new TableExporter();
            exporter.getSqlCreateStrings(entity);
        }
        

    }
}