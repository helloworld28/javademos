package com.powerjun.mybatis.mymybatis;

import java.lang.annotation.*;

/**
 * @author Jim
 * @date 2019/6/5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyIntercepts {
    Class target();

    String method();

}
