package com.example.lowcodesample.core.lowcode;

import cn.hutool.core.util.StrUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MysqlDialect {
    
    private Map<String, String> typeNames = new HashMap<>();
    
    public MysqlDialect() {
        registerColumnType(TypePrimitive.LONG, "bigint");
        registerColumnType(TypePrimitive.BOOLEAN, "bit");
        registerColumnType(TypePrimitive.INTEGER, "integer");
        registerColumnType(TypePrimitive.DOUBLE, "double precision");
        //registerColumnType(TypePrimitive.DECIMAL, "decimal($p,$s)");
        registerColumnType(TypePrimitive.DECIMAL, "decimal(10,2)");
        //registerColumnType(TypePrimitive.STRING, "varchar($c)");
        registerColumnType(TypePrimitive.STRING, "varchar(100)");
        registerColumnType(TypePrimitive.TEXT, "text");
        //registerColumnType(TypePrimitive.BINARY, "binary($l)");
        registerColumnType(TypePrimitive.BINARY, "binary(1000)");
        registerColumnType(TypePrimitive.DATE, "date");
        registerColumnType(TypePrimitive.TIME, "time");
        registerColumnType(TypePrimitive.DATETIME, "datetime");
    }
    
    public String getSqlType(String name) {
        return typeNames.get(name);
    }
    
    protected void registerColumnType(TypePrimitive code, String name) {
        typeNames.put(code.getTypeName(), name);
    }
    
    
    public String formatTableName(String tableName) {
        return tableName.toLowerCase();
    }
    
    public String tableCreateString() {
        return "create table";
    }
    
    public String getIdentityColumnString() {
        return "not null auto_increment";
    }
    
    public String getQuotedName(String name) {
        return openQuote() + name + closeQuote();
    }
    
    public char openQuote() {
        return '`';
    }
    
    public char closeQuote() {
        return '`';
    }
    
    public String getSqlType(Entity.TypeAnnotation typeAnnotation, MysqlDialect dialect) {
        return dialect.getSqlType(typeAnnotation.getTypeName());
    }
    
    
    public String getColumnComment(String comment) {
        return "comment '" + comment + "' ";
    }
    
    public String sqlConstraintString(List<Entity.Properties> properties) {
        StringBuilder buf = new StringBuilder("primary key (");
    
        String indexNames = properties.stream()
                .filter(Entity.Properties::isPrimaryKey)
                .map(item -> getQuotedName(item.getName()))
                .collect(Collectors.joining(StrUtil.COMMA));
        buf.append(indexNames);
        return buf.append(')').toString();
    }
    
    public String getTableComment(String comment) {
        return " comment='" + comment + "'";
    }
}