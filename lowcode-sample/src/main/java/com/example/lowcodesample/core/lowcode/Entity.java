package com.example.lowcodesample.core.lowcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
public class Entity {
    
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 数据库表名
     */
    private String tableName;
    /**
     * 描述
     */
    private String description;
    
    /**
     * 字段（列表）
     */
    private List<Properties> properties;
    
    /**
     * 索引（列表）
     */
    private List<Index> indexes;
    
    public boolean hasPrimaryKey(){
        return properties.stream()
                .anyMatch(Properties::isPrimaryKey);
    }
    
    /**
     * 字段
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Properties {
        private String id;
        /**
         * 名称
         */
        private String name;
        /**
         * 标题
         */
        private String label;
        /**
         * 描述
         */
        private String description;
        /**
         * 默认值
         */
        private String defaultValue;
        /**
         * 是否必填
         */
        private boolean required;
        /**
         * 是否主键
         */
        private boolean primaryKey;
        /**
         * 顺序
         */
        private Integer sequence;
        /**
         * 展示
         */
        private Display display;
        /**
         * 数据类型
         */
        private TypeAnnotation typeAnnotation;
        /**
         * 关联实体
         */
        private String relationEntity;
        /**
         * 关联属性
         */
        private String relationProperty;
        
        /**
         * 生成规则
         * auto 自动生成（内置字段：id 为雪花算法，创建时间和修改时间为当前时间、创建人和修改人为当前用户）
         */
        private String generationRule;
        
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Index {
        /**
         * 名称
         */
        private String name;
        /**
         * 属性（列表）
         */
        private List<String> propertyNames;
        /**
         * 是否唯一
         */
        private boolean unique;
        /**
         * 描述
         */
        private String description;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Display {
        /**
         * 显示在表格
         */
        private boolean inTable;
        /**
         * 显示在筛选
         */
        private boolean inFilter;
        /**
         * 显示在表单
         */
        private boolean inForm;
        /**
         * 显示在详情
         */
        private boolean inDetail;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TypeAnnotation {
        /**
         * 类型的类型
         * primitive 基础类型、generic 集合类型（List<T>、Map<K,V>，暂不支持）、reference 自定义类型（引用字典）
         */
        private String typeKind;
        /**
         * 类型
         */
        private String typeName;
    
        /**
         * 类型规则 Map
         */
        private Map<String, Object> typeRuleMap;
        
        public boolean isNumber() {
            return TypePrimitive.of(typeName).isNumber();
        }
        
        public boolean isNotNumber() {
            return !isNumber();
        }
    }
    
}