package com.popwerjun.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * Created by Administrator on 2019/7/9.
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        //获取属性

        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        ConfigurableEnvironment environment = genericApplicationContext.getEnvironment();
        boolean name = environment.containsProperty("name");
    }

    @Configuration
    @PropertySource("demo.properties")
    class AppConfig {
        @Autowired
        Environment env;

        public Foo foo() {
            String name = env.getProperty("name");
            return new Foo(name);
        }
    }
}
