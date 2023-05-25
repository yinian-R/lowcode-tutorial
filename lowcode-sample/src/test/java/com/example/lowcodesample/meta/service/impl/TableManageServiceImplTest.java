package com.example.lowcodesample.meta.service.impl;

import com.example.lowcodesample.meta.service.api.TableManageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Access;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TableManageServiceImplTest {
    
    @Autowired
    private TableManageService tableManageService;
    
    @Test
    void createTable() {
        tableManageService.createTable();
    }
}