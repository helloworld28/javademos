package com.powerjun.mybatis.mymybatis;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class MySqlSessionFactory {

    private String baseMapperPackage;
    private String url;
    private String username;
    private String password;
    private MyConfiguration myConfiguration;

    public void init() {
        myConfiguration = new MyConfiguration(baseMapperPackage, url, username, password);
    }

    public MySqlSession openSession() {
        DefaultMyExecutor defaultMyExecutor = new DefaultMyExecutor(myConfiguration);
        return new DefaultMySqlSession(myConfiguration, defaultMyExecutor);
    }


    public String getBaseMapperPackage() {
        return baseMapperPackage;
    }

    public void setBaseMapperPackage(String baseMapperPackage) {
        this.baseMapperPackage = baseMapperPackage;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
