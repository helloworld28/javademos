package com.powerjun.mybatis.mymybatis;

import java.util.List;
import java.util.Map;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class DefaultMySqlSession implements MySqlSession {


    private MyConfiguration myConfiguration;
    private MyExecutor myExecutor;


    public DefaultMySqlSession(MyConfiguration myConfiguration, MyExecutor myExecutor) {
        this.myConfiguration = myConfiguration;
        this.myExecutor = myExecutor;
    }

    @Override
    public <T> List<T> queryList(String statement,Object[] args, Class<T> tClass) {
        return myExecutor.queryList(statement, args, tClass);
    }


    @Override
    public <T> T getMapper(Class<T> clazz) {
        return myConfiguration.getMapper(clazz, this);
    }
}
