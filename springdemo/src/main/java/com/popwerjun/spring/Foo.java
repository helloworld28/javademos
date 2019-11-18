package com.popwerjun.spring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2019/6/12.
 */
public class Foo  {

    private String name;

    private Foo2 foo2;

    @Autowired
    public Foo(Foo2 foo2) {
        this.foo2 = foo2;
    }

    public Foo() {
    }

    public Foo(String name) {
        this.name = name;
    }

    public void bar(){
        System.out.println("bar!!!!!!!!!!!!111");
    }

}
