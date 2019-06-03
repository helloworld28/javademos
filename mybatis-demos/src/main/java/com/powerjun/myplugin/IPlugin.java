package com.powerjun.myplugin;

import org.apache.ibatis.plugin.Invocation;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jim
 * @date 2019/6/3
 */
public interface IPlugin {

    Object intercept(Object target, Method method, Object[] args);

//    public static plugin(Object obecth, Object this){
//        new Proxy.newProxyInstance()
//    }
}
