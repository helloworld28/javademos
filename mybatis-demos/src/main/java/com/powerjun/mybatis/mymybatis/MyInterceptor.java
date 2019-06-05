package com.powerjun.mybatis.mymybatis;

/**
 * @author Jim
 * @date 2019/6/5
 */
public interface MyInterceptor {

    Object interceptor(MyInvocation myInvocation);

    Object plugin(Object target, MyInterceptor myInterceptor);
}
