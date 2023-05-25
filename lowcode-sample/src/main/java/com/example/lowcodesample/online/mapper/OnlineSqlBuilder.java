package com.example.lowcodesample.online.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.example.lowcodesample.core.lowcode.Entity;
import com.example.lowcodesample.online.model.vo.SelectSql;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OnlineSqlBuilder {
    
    public String buildByParams(@Param("selectSql") SelectSql selectSql, @Param("entity") Entity entity) {
        Map<String, Entity.Properties> propertiesMap = entity.getProperties()
                .stream()
                .collect(Collectors.toMap(Entity.Properties::getName, Function.identity()));
        
        return new SQL() {
            {
                // 查询字段
                SELECT(selectSql.getColumnsStr());
                // 表
                FROM(entity.getTableName());
                // 条件
                where();
                // 排序
                order();
            }
            
            private void where() {
                for (SelectSql.Filter filter : selectSql.getFilters()) {
                    String name = filter.getName();
                    String value = filter.getValue();
                    
                    if (filter.getConditionType().equals(SqlKeyword.LIKE.name())) {
                        like(name, value);
                    } else if (filter.getConditionType().equals(SqlKeyword.EQ.name())) {
                        eq(name, value);
                    } else if (filter.getConditionType().equals(SqlKeyword.IN.name())) {
                        in(name, value);
                    }
                }
            }
            
            private void in(String name, String value) {
                if (ObjectUtils.isNotEmpty(value)) {
                    Entity.Properties properties = propertiesMap.get(name);
                    if (properties.getTypeAnnotation().isNotNumber()) {
                        value = StrUtil.splitTrim(value, StrUtil.COMMA).stream()
                                .map(v -> StringPool.SINGLE_QUOTE + v + StringPool.SINGLE_QUOTE)
                                .collect(Collectors.joining(StrUtil.COMMA));
                    }
                    String condition = String.format(" %s in (%s) ", name, value);
                    WHERE(condition);
                }
            }
            
            private void like(String name, String value) {
                if (ObjectUtils.isNotEmpty(value)) {
                    value = StringPool.PERCENT + value + StringPool.PERCENT;
                    value = StringPool.SINGLE_QUOTE + value + StringPool.SINGLE_QUOTE;
                    
                    String condition = String.format(" %s LIKE %s ", name, value);
                    WHERE(condition);
                }
            }
            
            private void eq(String name, String value) {
                if (ObjectUtils.isNotEmpty(value)) {
                    Entity.Properties properties = propertiesMap.get(name);
                    if (properties.getTypeAnnotation().isNotNumber()) {
                        value = StringPool.SINGLE_QUOTE + value + StringPool.SINGLE_QUOTE;
                    }
                    String condition = String.format(" %s = %s ", name, value);
                    WHERE(condition);
                }
            }
            
            private void order() {
                if (selectSql.hasOrderColumns()) {
                    selectSql.getOrderColumns().forEach(this::ORDER_BY);
                }
            }
        }.toString();
    }
    
}
