package com.powerjun.mybatis;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author Jim
 * @date 2019/6/3
 */
@Intercepts(
        @Signature(type = ResultSetHandler.class,
                method = "handleResultSets",
                args = {Statement.class})
)
public class Test2Interceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Test2Interceptor intercept...");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
