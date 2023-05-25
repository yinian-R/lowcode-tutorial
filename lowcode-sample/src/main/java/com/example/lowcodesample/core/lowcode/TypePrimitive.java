package com.example.lowcodesample.core.lowcode;

import lombok.Getter;
@Getter
public enum TypePrimitive {
    LONG("Long", "Long 长整数", true),
    BOOLEAN("Boolean", "Boolean 布尔值", false),
    INTEGER("Integer", "Integer 整数", true),
    DOUBLE("Double", "Double 小数", true),
    DECIMAL("Decimal", "Decimal 精确小数", true),
    STRING("String", "String 字符串", false),
    TEXT("Text", "Text 长文本", false),
    BINARY("Binary", "Binary 二进制流", false),
    DATE("Date", "Date 日期", false),
    TIME("Time", "Time 时间", false),
    DATETIME("DateTime", "DateTime 日期时间", false),
    ;
    
    private final String typeName;
    private final String label;
    private final boolean isNumber;
    
    TypePrimitive(String typeName, String label, Boolean isNumber) {
        this.typeName = typeName;
        this.label = label;
        this.isNumber = isNumber;
    }
    
    public static TypePrimitive of(String typeName) {
        for (TypePrimitive typePrimitive : values()) {
            if (typePrimitive.typeName.equals(typeName)) {
                return typePrimitive;
            }
        }
        throw new IllegalArgumentException("未知类型 " + typeName);
    }
}
