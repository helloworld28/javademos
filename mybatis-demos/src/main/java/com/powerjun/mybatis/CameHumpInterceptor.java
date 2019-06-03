package com.powerjun.mybatis;


import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jim
 * @date 2019/6/3
 */

@Intercepts(
        @Signature(
                type = ResultSetHandler.class,
                method = "handleResultSets",
                args = {Statement.class}
        )
)
public class CameHumpInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List<Object> results = (List<Object>) invocation.proceed();

        System.out.println("CameHumpInterceptor intercept...");
        return results.stream().peek(obj -> {
            if (obj instanceof Map) {
                prosessMap((Map) obj);
            }

        }).collect(Collectors.toList());
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    public void prosessMap(Map map) {
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            if ((key.charAt(0) > 'A' && key.charAt(0) < 'Z') || key.indexOf("_") > 0) {
                map.put(underlineToCamelhump(key), map.remove(key));
            }
        }
    }

    public static String underlineToCamelhump(String inputString) {

        boolean nextUpperCase = false;
        StringBuilder newStr = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (c == '_') {
                nextUpperCase = true;
                continue;
            }
            if (nextUpperCase) {
                newStr.append(Character.toUpperCase(c));
                nextUpperCase = false;
            } else {
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString();
    }
}
