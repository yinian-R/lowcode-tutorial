package com.example.lowcodesample.online.service.api;

import com.example.lowcodesample.online.model.vo.SelectSql;

import java.util.List;
import java.util.Map;

public interface OnlineService {
    List<Map<String, Object>> selectList(SelectSql selectSql);
}
