package com.example.lowcodesample.online.controller;

import com.example.lowcodesample.online.model.vo.SelectSql;
import com.example.lowcodesample.online.service.api.OnlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/online")
@RequiredArgsConstructor
@RestController
public class OnlineController {
    
    private final OnlineService onlineService;
    
    @PostMapping("/findList")
    public Object findList(@RequestBody SelectSql selectSql) {
        return onlineService.selectList(selectSql);
    }
    
}
