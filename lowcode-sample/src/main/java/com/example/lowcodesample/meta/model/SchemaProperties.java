package com.example.lowcodesample.meta.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 字段表(SchemaProperties)表实体类
 *
 * @author hrj
 * @since 2023-02-22 14:18:52
 */
@ApiModel(value = "字段表")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchemaProperties {
    private String id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String label;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
    /**
     * 默认值
     */
    @ApiModelProperty(value = "默认值")
    private String defaultValue;
    /**
     * 是否必填
     */
    @ApiModelProperty(value = "是否必填")
    private Boolean required;
    /**
     * 是否主键
     */
    @ApiModelProperty(value = "是否主键")
    private Boolean primaryKey;
    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序")
    private Integer sequence;
    /**
     * 显示在表格
     */
    @ApiModelProperty(value = "显示在表格")
    private Boolean inTable;
    /**
     * 显示在筛选
     */
    @ApiModelProperty(value = "显示在筛选")
    private Boolean inFilter;
    /**
     * 显示在表单
     */
    @ApiModelProperty(value = "显示在表单")
    private Boolean inForm;
    /**
     * 显示在详情
     */
    @ApiModelProperty(value = "显示在详情")
    private Boolean inDetail;
    /**
     * 类型的类型
     */
    @ApiModelProperty(value = "类型的类型")
    private String typeKind;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String typeName;
    /**
     * 类型属性
     */
    @ApiModelProperty(value = "类型属性")
    private String typeRuleMap;
    /**
     * 关联实体
     */
    @ApiModelProperty(value = "关联实体")
    private String relationEntity;
    /**
     * 关联属性
     */
    @ApiModelProperty(value = "关联属性")
    private String relationProperty;
    /**
     * 生成规则
     */
    @ApiModelProperty(value = "生成规则")
    private String generationRule;
    /**
     * 实体唯一ID
     */
    @ApiModelProperty(value = "实体唯一ID")
    private String relationEntityId;
    
}

