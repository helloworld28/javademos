package com.popwerjun.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/7/8.
 */
@Component
public class BeanDefinitionDemo {

    @Bean
    @Qualifier("mapBean")
    public HashMap getMap() {
        return new HashMap<>();
    }


    @Bean
    public ThingThree thingThreeInstance(@Qualifier("thingOne") ThingOne thingOne,
                                         @Qualifier("thingTwo") ThingTwo thingTwo)

    {
        return new ThingThree(thingOne, thingTwo);
    }

    @Bean
    public Foo fooBean(@Value("${name}") String name) {
        return new Foo(name);
    }

}
