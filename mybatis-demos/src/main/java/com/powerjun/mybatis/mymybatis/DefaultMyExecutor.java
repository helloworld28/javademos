package com.powerjun.mybatis.mymybatis;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class DefaultMyExecutor implements MyExecutor {

    private MyConfiguration myConfiguration;

    public DefaultMyExecutor(MyConfiguration myConfiguration) {
        this.myConfiguration = myConfiguration;
    }

    @Override
    public <T> List<T> queryList(String statement, Object[] args, Class<T> tClass) {

        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            resultSet = new StatementHandler(connection).doQuery(statement, args);
            List<T> handle = new ResultSetHandler().handle(resultSet, tClass);
            return handle;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            MysqlDataSource mysqlConnectionPoolDataSource = new MysqlConnectionPoolDataSource();
            mysqlConnectionPoolDataSource.setURL(myConfiguration.getUrl());
            mysqlConnectionPoolDataSource.setUser(myConfiguration.getUsername());
            mysqlConnectionPoolDataSource.setPassword(myConfiguration.getPassword());

            connection = mysqlConnectionPoolDataSource.getConnection();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
