package com.xubo.votesystem.handler;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * git
 * @Author xubo
 * @Date 2022/1/11 15:50
 * Mybatis 优雅的缓存 json  从源码的角度分析
 * https://blog.csdn.net/qq271859852/article/details/103330914
 *
 * 自定义实体类 类型转换
 * 继承 BaseTypeHandler 这个抽象类  实现下面四个方法
 * BaseTypeHandler 继承 TypeReference ，TypeReference中 getSuperclassTypeParameter() 提取泛型具体类，也就是这个里面的T，后面的类继承AbstractObjectTypeHandler 会传具体的实体类
 *
 */
public abstract class AbstractObjectTypeHandler<T> extends BaseTypeHandler<T> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T params, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, this.toJson(params));
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        String json = resultSet.getString(columnName);
        return StringUtils.isBlank(json) ? null : this.parse(json);
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String json = resultSet.getString(columnIndex);
        return StringUtils.isBlank(json) ? null : this.parse(json);
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        String json = callableStatement.getString(columnIndex);
        return StringUtils.isBlank(json) ? null : this.parse(json);
    }

    protected T parse(String json) {
        try {
            return JSONObject.parseObject(json, (Class<T>) getRawType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String toJson(T t) {
        try {
            return JSONObject.toJSONString(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
