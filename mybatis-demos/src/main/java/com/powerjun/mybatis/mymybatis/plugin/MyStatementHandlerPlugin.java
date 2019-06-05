package com.powerjun.mybatis.mymybatis.plugin;

import com.powerjun.mybatis.mymybatis.*;

/**
 * @author Jim
 * @date 2019/6/5
 */
@MyIntercepts(target = MyStatementHandler.class, method = "handle")
public class MyStatementHandlerPlugin implements MyInterceptor {

    @Override
    public Object interceptor(MyInvocation myInvocation) {
        System.out.println("TestMyPlugin1 interceptor->" +myInvocation.getProxy().getClass().getSimpleName()+":"+ myInvocation.getMethod().getName());
        return myInvocation.proceed();
    }

    @Override
    public Object plugin(Object target, MyInterceptor myInterceptor) {
        return MyPlugin.wrap(target, this);
    }
}
