package com.example.lowcodesample.meta.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体表(SchemaEntity)表实体类
 *
 * @author hrj
 * @since 2023-02-22 14:18:52
 */
@ApiModel(value = "实体表")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchemaEntity {
    private String id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 数据库表名
     */
    @ApiModelProperty(value = "数据库表名")
    private String tableName;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
    
}

