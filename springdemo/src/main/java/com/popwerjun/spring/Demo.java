package com.popwerjun.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/12.
 */
@Test
public class Demo {
    ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @BeforeTest
    public void init() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Foo bean = classPathXmlApplicationContext.getBean(Foo.class);
        Foo2 bean2 = classPathXmlApplicationContext.getBean(Foo2.class);
        bean.bar();
        bean2.doSomeThing();
    }

    @Test
    public void testAlias() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Foo foo = classPathXmlApplicationContext.getBean("foo4", Foo.class);
        foo.bar();

    }

    @Test
    public void testFactoryMethod() {
        ClientService clientService = classPathXmlApplicationContext.getBean("clientService", ClientService.class);
        clientService.foo();
    }

    @Test
    public void testInstanceCreateMethod() {
        ClientService clientService2 = classPathXmlApplicationContext.getBean("clientService2", ClientService.class);
        clientService2.foo();
    }


}
