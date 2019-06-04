package com.powerjun.mybatis.mymybatis;

import java.lang.annotation.*;

/**
 * @author Jim
 * @date 2019/6/4
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MySelect {
    String value();

    Class returnType();
}
