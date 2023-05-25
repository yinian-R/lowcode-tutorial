package com.example.lowcodesample.meta.hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.hibernate.tool.schema.internal.SchemaCreatorImpl;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class CreateTableTest {
    
    
    /**
     * Generates database create commands for the specified entities using Hibernate native API, SchemaExport.
     * Creation commands are exported into the create.sql file.
     * 执行创建表：{@link SchemaCreatorImpl#createFromMetadata}
     * 生成SQL：{@link StandardTableExporter#getSqlCreateStrings}
     */
    @Test
    public void generateSchema() {
        Map<String, String> settings = new HashMap<>();
        settings.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/lowcode_sample?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
        
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Account.class);
        metadataSources.addAnnotatedClass(AccountSetting.class);
        Metadata metadata = metadataSources.buildMetadata();
        
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setFormat(true);
        schemaExport.setOutputFile("create.sql");
        schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadata);
    }
    
}
