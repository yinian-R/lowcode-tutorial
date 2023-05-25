package com.example.lowcodesample.core.mybatis;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListStringTypeHandler extends BaseTypeHandler<List<String>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, ObjectUtils.isNotEmpty(parameter) ? StrUtil.join(StrUtil.COMMA, parameter) : null);
    }
    
    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        return ObjectUtils.isNotEmpty(str) ? StrUtil.splitTrim(str, StrUtil.COMMA) : new ArrayList<>();
    }
    
    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return ObjectUtils.isNotEmpty(str) ? StrUtil.splitTrim(str, StrUtil.COMMA) : new ArrayList<>();
    }
    
    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return ObjectUtils.isNotEmpty(str) ? StrUtil.splitTrim(str, StrUtil.COMMA) : new ArrayList<>();
    }
}
