package com.example.lowcodesample.meta.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 索引表(SchemaIndexes)表实体类
 *
 * @author hrj
 * @since 2023-02-22 14:18:52
 */
@ApiModel(value = "索引表")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchemaIndexes  {
    private String id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 属性，多个逗号隔开
     */
    @ApiModelProperty(value = "属性，多个逗号隔开")
    private String propertyNames;
    /**
     * 是否唯一
     */
    @ApiModelProperty(value = "是否唯一")
    private Boolean unique;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
    /**
     * 实体唯一ID
     */
    @ApiModelProperty(value = "实体唯一ID")
    private String relationEntityUuid;
    
}

