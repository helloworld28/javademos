package com.powerjun.mybatis.mymybatis;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    private static Map<Class, List<MyInterceptor>> clzToInterceptors = new HashMap<>();
    private static Map<MyInterceptor, String> interceptorToMethoMap = new HashMap<>();


    MyConfiguration(String mapperBasePackage, String url, String username, String password) {
        this.mapperBasePackage = mapperBasePackage;
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            init(mapperBasePackage);
            initInterceptorChain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void init(String basePackage) throws ClassNotFoundException {
        String dir = basePackage.replace(".", "/");
        String classPath = MyConfiguration.class.getClassLoader().getResource("").getPath();
        File file = new File(classPath + "/" + dir);

        for (String fileName : file.list()) {

            String clazz = getKey(basePackage, fileName.substring(0, fileName.lastIndexOf(".")));
            Class<?> aClass = Class.forName(clazz, true, MyConfiguration.class.getClassLoader());
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                MySelect annotation = method.getAnnotation(MySelect.class);
                String sql = annotation.sql();
                keyToSqlMap.put(getKey(clazz, method.getName()), sql);
                keyToResultTypeMap.put(getKey(clazz, method.getName()), annotation.returnType());
            }
        }
    }

    private void initInterceptorChain() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String basePackage = mapperBasePackage.substring(0, mapperBasePackage.lastIndexOf(".")) + "." + "plugin";
        String dir = basePackage.replace(".", "/");
        String classPath = MyConfiguration.class.getClassLoader().getResource("").getPath();
        File file = new File(classPath + "/" + dir);

        for (String fileName : file.list()) {
            String clazz = getKey(basePackage, fileName.substring(0, fileName.lastIndexOf(".")));
            Class<?> aClass = Class.forName(clazz, true, MyConfiguration.class.getClassLoader());
            MyIntercepts myIntercepts = aClass.getAnnotation(MyIntercepts.class);

            Class target = myIntercepts.target();
            String method = myIntercepts.method();
            MyInterceptor myInterceptor = (MyInterceptor) aClass.newInstance();
            clzToInterceptors.computeIfAbsent(target, (key) -> new ArrayList<>()).add(myInterceptor);
            interceptorToMethoMap.put(myInterceptor, method);
        }
    }

    private String getKey(String clazz, String name) {
        return String.format("%s.%s", clazz, name);
    }


    <T> T getMapper(Class<T> clazz, MySqlSession mySqlSession) {
        return (T) Proxy.newProxyInstance(DefaultMySqlSession.class.getClassLoader(), new Class[]{clazz}, new MyMapperProxy(mySqlSession, this));
    }

    Map<String, String> getKeyToSqlMap() {
        return keyToSqlMap;
    }


    Map<String, Class> getKeyToResultTypeMap() {
        return keyToResultTypeMap;
    }


    MyStatementHandler newStatementHandler(Connection connection) {
        MyStatementHandler statementHandler = new DefaultStatementHandler(connection);
        return (MyStatementHandler) pluginAll(statementHandler);
    }

    MyResultSetHandler newResultSetHandler() {
        return (MyResultSetHandler) pluginAll(new DefaultResultSetHandler());
    }

    Object pluginAll(Object object) {
        Object target = object;
        Class[] interfaces = getInterfaces(object);
        for (Class interfaceClz : interfaces) {
            List<MyInterceptor> myInterceptors = clzToInterceptors.get(interfaceClz);
            if (myInterceptors != null) {
                for (MyInterceptor myInterceptor : myInterceptors) {
                    target = myInterceptor.plugin(target, myInterceptor);
                }
            }
        }
        return target;
    }

    static Map<MyInterceptor, String> getInterceptorToMethodMap() {
        return interceptorToMethoMap;
    }

    Class[] getInterfaces(Object object) {
        Class<?>[] interfaces = object.getClass().getInterfaces();
        List<Class> resultInterface = new ArrayList<>();
        for (Class clazz : interfaces) {
            if (clzToInterceptors.containsKey(clazz)) {
                resultInterface.add(clazz);
            }
        }
        return resultInterface.toArray(new Class[resultInterface.size()]);
    }

    String getUrl() {
        return url;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
