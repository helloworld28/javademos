package com.powerjun.mybatis.mymybatis;

import java.util.List;

/**
 * @author Jim
 * @date 2019/6/4
 */
public interface MySqlSession {


    <T> List<T> queryList(String statement,Object[] args, Class<T> tClass);

    <T> T getMapper(Class<T> clazz);
}
