package com.example.lowcodesample.meta.controller;

import com.example.lowcodesample.meta.service.api.TableManageService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/tableManage")
@RestController
public class TableManageController {
    
    private final TableManageService tableManageService;
    
    @ApiOperation("基于数据模型创建表")
    @PostMapping
    public void createTable(){
        tableManageService.createTable();
    }
}
