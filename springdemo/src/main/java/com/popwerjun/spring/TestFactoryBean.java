package com.popwerjun.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * Created by Administrator on 2019/7/2.
 */
public class TestFactoryBean implements FactoryBean<Foo> {
    @Nullable
    @Override
    public Foo getObject() throws Exception {
        return new Foo();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Foo.class;
    }
}
