package com.powerjun.mybatis.mymybatis;

import java.util.List;

/**
 * @author Jim
 * @date 2019/6/4
 */
public interface MyExecutor {
    <T> List<T> queryList(String statement, Object[] args, Class<T> tClass);
}
