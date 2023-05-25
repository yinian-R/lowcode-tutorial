CREATE TABLE `schema_entity`
(
    `id`          varchar(50) NOT NULL COMMENT '实体唯一ID',
    `name`        varchar(20) NOT NULL COMMENT '名称',
    `table_name`  varchar(20) NOT NULL COMMENT '数据库表名',
    `description` varchar(50) DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT='实体表';


CREATE TABLE `schema_indexes`
(
    `id`                 varchar(50) NOT NULL COMMENT '索引唯一ID',
    `name`               varchar(20) NOT NULL COMMENT '名称',
    `property_names`     varchar(50) NOT NULL COMMENT '属性，多个逗号隔开',
    `unique`             tinyint(1) NOT NULL COMMENT '是否唯一',
    `description`        varchar(50) DEFAULT NULL COMMENT '描述',
    `relation_entity_id` varchar(50) NOT NULL COMMENT '实体唯一ID',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT='索引表';


CREATE TABLE `schema_properties`
(
    `id`                 varchar(50) NOT NULL COMMENT '字段唯一ID',
    `name`               varchar(20) NOT NULL COMMENT '名称',
    `label`              varchar(20) NOT NULL COMMENT '标题',
    `description`        varchar(50) DEFAULT NULL COMMENT '描述',
    `default_value`      varchar(20) DEFAULT NULL COMMENT '默认值',
    `required`           tinyint(1) NOT NULL COMMENT '是否必填',
    `primary_key`        tinyint(1) DEFAULT NULL COMMENT '是否主键',
    `sequence`           int         DEFAULT NULL COMMENT '顺序',
    `in_table`           tinyint(1) NOT NULL COMMENT '显示在表格',
    `in_filter`          tinyint(1) NOT NULL COMMENT '显示在筛选',
    `in_form`            tinyint(1) NOT NULL COMMENT '显示在表单',
    `in_detail`          tinyint(1) NOT NULL COMMENT '显示在详情',
    `type_kind`          varchar(20) NOT NULL COMMENT '类型的类型',
    `type_name`          varchar(20) NOT NULL COMMENT '类型',
    `type_rule_map`      json        DEFAULT NULL COMMENT '类型属性',
    `relation_entity`    varchar(20) DEFAULT NULL COMMENT '关联实体',
    `relation_property`  varchar(20) DEFAULT NULL COMMENT '关联属性',
    `generation_rule`    varchar(20) NOT NULL COMMENT '生成规则',
    `relation_entity_id` varchar(50) NOT NULL COMMENT '实体唯一ID',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT='字段表';