package com.powerjun.mybatis.mymybatis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Jim
 * @date 2019/6/5
 */
public class MyInvocation {

    private Object proxy;
    Method method;
    Object[] args;

    public MyInvocation(Object proxy, Method method, Object[] args) {
        this.proxy = proxy;
        this.method = method;
        this.args = args;
    }

    public Object proceed() {
        try {
            return method.invoke(proxy, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getProxy() {
        return proxy;
    }

    public Method getMethod() {
        return method;
    }
}
