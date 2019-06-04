package com.powerjun.mybatis.mymybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class StatementHandler {


    private Connection connection;

    public StatementHandler(Connection connection) {
        this.connection = connection;
    }

    public ResultSet doQuery(String statement, Object[] args) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        }

        return preparedStatement.executeQuery();

    }

}
