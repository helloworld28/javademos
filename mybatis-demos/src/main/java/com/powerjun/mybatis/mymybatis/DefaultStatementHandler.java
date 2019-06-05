package com.powerjun.mybatis.mymybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class DefaultStatementHandler implements MyStatementHandler {


    private Connection connection;

    public DefaultStatementHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ResultSet handle(String statement, Object[] args) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        }

        return preparedStatement.executeQuery();

    }

    @Override
    public void foo() {
        System.out.println("bar!!!!!!!!!!!!!!!!!");
    }

}
