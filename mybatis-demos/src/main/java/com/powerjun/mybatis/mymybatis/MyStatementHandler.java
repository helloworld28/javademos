package com.powerjun.mybatis.mymybatis;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jim
 * @date 2019/6/5
 */
public interface MyStatementHandler {
    ResultSet handle(String statement, Object[] args) throws SQLException;

    void foo();
}
