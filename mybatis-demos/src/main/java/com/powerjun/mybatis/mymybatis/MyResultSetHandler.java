package com.powerjun.mybatis.mymybatis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Jim
 * @date 2019/6/5
 */
public interface MyResultSetHandler {
    <T> List<T> handle(ResultSet resultSet, Class<T> tClass) throws SQLException;
}
