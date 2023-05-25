package com.example.lowcodesample.online.model.vo;

import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.example.lowcodesample.online.mapper.OnlineSqlBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Data
public class SelectSql {
    
    /**
     * 实体名称
     */
    @ApiModelProperty("实体名称")
    private String name;
    
    /**
     * 查询列，若无则为 *
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private List<String> columns;
    
    /**
     * 查询条件
     */
    @ApiModelProperty("查询条件")
    private List<Filter> filters;
    
    /**
     * 排序
     * 格式：
     * field desc/asc
     */
    @ApiModelProperty("排序")
    private List<String> orderColumns;
    
    public String getColumnsStr() {
        return Optional.ofNullable(columns)
                .filter(ObjectUtils::isNotEmpty)
                .map(v -> String.join(StringPool.COMMA, v))
                .orElse(StringPool.ASTERISK);
    }
    
    public Boolean hasOrderColumns() {
        return ObjectUtils.isNotEmpty(orderColumns);
    }
    
    @Data
    public static class Filter {
        
        /**
         * 条件类型：LIKE 、EQ、IN
         * {@link OnlineSqlBuilder} and {@link SqlKeyword}
         */
        @ApiModelProperty("条件类型，例如 LIKE/EQ/IN")
        private String conditionType;
    
        /**
         * 字段名称
         */
        @ApiModelProperty("字段名称")
        private String name;
    
        /**
         * 条件值，多选时逗号隔开
         */
        @ApiModelProperty("条件值，多选时逗号隔开")
        private String value;
        
    }
}
