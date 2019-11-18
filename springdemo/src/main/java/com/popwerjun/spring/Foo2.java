package com.popwerjun.spring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jim
 * @date 2019/6/17
 */
public class Foo2 {

    @Autowired
    private Foo foo;

    public void doSomeThing() {

        foo.bar();

    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}
