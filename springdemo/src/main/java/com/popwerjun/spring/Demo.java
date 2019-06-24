package com.popwerjun.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2019/6/12.
 */
public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Foo bean = classPathXmlApplicationContext.getBean(Foo.class);
        bean.bar();
    }




}
