package com.example.lowcodesample.online.service.impl;

import com.example.lowcodesample.core.lowcode.Entity;
import com.example.lowcodesample.online.model.vo.SelectSql;
import com.example.lowcodesample.meta.mapper.SchemaEntityMapper;
import com.example.lowcodesample.online.mapper.OnlineMapper;
import com.example.lowcodesample.online.service.api.OnlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OnlineServiceImpl implements OnlineService {
    
    private final OnlineMapper onlineMapper;
    private final SchemaEntityMapper schemaEntityMapper;
    
    @Override
    public List<Map<String, Object>> selectList(SelectSql selectSql) {
        Entity entity = schemaEntityMapper.findByName(selectSql.getName());
        
        // 获取可查询字段
        List<String> availableColumns = entity.getProperties().stream()
                .filter(v -> v.isPrimaryKey()
                        || v.getDisplay().isInFilter() || v.getDisplay().isInDetail()
                        || v.getDisplay().isInForm() || v.getDisplay().isInTable())
                .map(Entity.Properties::getName)
                .collect(Collectors.toList());
        selectSql.setColumns(availableColumns);
        
        return onlineMapper.selectList(selectSql, entity);
    }
}
