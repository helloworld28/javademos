package com.powerjun.mybatis.mymybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class MyMapperProxy implements InvocationHandler {

    private MySqlSession mySqlSession;

    private MyConfiguration myConfiguration;

    public MyMapperProxy(MySqlSession mySqlSession, MyConfiguration myConfiguration) {
        this.mySqlSession = mySqlSession;
        this.myConfiguration = myConfiguration;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String key = String.format("%s.%s", method.getDeclaringClass().getName(), method.getName());


        Class tClass = myConfiguration.getKeyToResultTypeMap().get(key);
        String statement = myConfiguration.getKeyToSqlMap().get(key);

        if (tClass == null) {
            throw new IllegalArgumentException("还未配置相关返回值:" + key);
        }
        if (statement == null) {
            throw new IllegalArgumentException("还未配置相关sql:" + key);
        }
        return mySqlSession.queryList(statement, args, tClass);
    }

}
