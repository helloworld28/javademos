package com.powerjun.mybatis.mymybatis;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class DefaultResultSetHandler implements MyResultSetHandler {

    @Override
    public <T> List<T> handle(ResultSet resultSet, Class<T> tClass) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        List<T> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T t = tClass.newInstance();
                int i = 1;
                for (; i <= metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnName(i);

                    Field declaredField = tClass.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    if (declaredField.getGenericType() == String.class) {
                        declaredField.set(t, resultSet.getString(columnName));
                    } else if (declaredField.getGenericType() == Long.class) {
                        declaredField.set(t, resultSet.getLong(columnName));
                    }
                }
                resultList.add(t);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
