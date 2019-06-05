package com.powerjun.mybatis.mymybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jim
 * @date 2019/6/5
 */
public class MyPlugin implements InvocationHandler {

    private Object target;

    private MyInterceptor myInterceptor;


    public MyPlugin(Object target, MyInterceptor myInterceptor) {
        this.target = target;
        this.myInterceptor = myInterceptor;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = MyConfiguration.getInterceptorToMethodMap().get(myInterceptor);
        if (methodName != null && methodName.equals(method.getName())) {
            return myInterceptor.interceptor(new MyInvocation(target, method, args));
        } else {
            return method.invoke(target, args);
        }
    }

    public static Object wrap(Object target, MyInterceptor myInterceptor) {

        return Proxy.newProxyInstance(MyPlugin.class.getClassLoader(), target.getClass().getInterfaces(), new MyPlugin(target, myInterceptor));
    }
}
