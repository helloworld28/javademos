package com.powerjun.mybatis.mymybatis;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class MyConfiguration {

    private String mapperBasePackage = "";
    private String url;
    private String username;
    private String password;
    private Map<String, String> keyToSqlMap = new HashMap<>();
    private Map<String, Class> keyToResultTypeMap = new HashMap<>();


    public MyConfiguration(String mapperBasePackage, String url, String username, String password) {
        this.mapperBasePackage = mapperBasePackage;
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            init(mapperBasePackage);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void init(String basePackage) throws ClassNotFoundException {
        String dir = basePackage.replace(".", "/");
        String classPath = MyConfiguration.class.getClassLoader().getResource("").getPath();
        File file = new File(classPath + "/" + dir);

        for (String fileName : file.list()) {

            String clazz = getKey(basePackage, fileName.substring(0, fileName.lastIndexOf(".")));
            Class<?> aClass = Class.forName(clazz, true, MyConfiguration.class.getClassLoader());
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                MySelect annotation = method.getAnnotation(MySelect.class);
                String sql = annotation.value();
                keyToSqlMap.put(getKey(clazz, method.getName()), sql);
                keyToResultTypeMap.put(getKey(clazz, method.getName()), annotation.returnType());
            }
        }
    }

    private String getKey(String clazz, String name) {
        return String.format("%s.%s", clazz, name);
    }


    public <T> T getMapper(Class<T> clazz, MySqlSession mySqlSession) {
        return (T) Proxy.newProxyInstance(DefaultMySqlSession.class.getClassLoader(), new Class[]{clazz}, new MyMapperProxy(mySqlSession, this));
    }

    public Map<String, String> getKeyToSqlMap() {
        return keyToSqlMap;
    }

    public void setKeyToSqlMap(Map<String, String> keyToSqlMap) {
        this.keyToSqlMap = keyToSqlMap;
    }

    public Map<String, Class> getKeyToResultTypeMap() {
        return keyToResultTypeMap;
    }

    public void setKeyToResultTypeMap(Map<String, Class> keyToResultTypeMap) {
        this.keyToResultTypeMap = keyToResultTypeMap;
    }

    public static void main(String[] args) {

        String dir = "com.powerjun.mybatis.mymybatis.mapper".replace(".", "/");
        String classPath = MyConfiguration.class.getClassLoader().getResource("").getPath();
        File file = new File(classPath + "/" + dir);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.list());
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
