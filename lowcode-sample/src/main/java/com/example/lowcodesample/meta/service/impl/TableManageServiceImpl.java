package com.example.lowcodesample.meta.service.impl;

import com.example.lowcodesample.core.lowcode.Entity;
import com.example.lowcodesample.meta.mapper.SchemaEntityMapper;
import com.example.lowcodesample.meta.mapper.TableManageMapper;
import com.example.lowcodesample.meta.service.api.TableManageService;
import com.example.lowcodesample.meta.tool.schema.TableExporter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TableManageServiceImpl implements TableManageService {
    
    private final SchemaEntityMapper schemaEntityMapper;
    private final TableManageMapper tableManageMapper;
    
    @Override
    public void createTable() {
        for (Entity entity : schemaEntityMapper.findList()) {
            TableExporter exporter = new TableExporter();
            String[] sqlArray = exporter.getSqlCreateStrings(entity);
            for (String sql : sqlArray) {
                tableManageMapper.exec(sql);
            }
        }
    }
}
