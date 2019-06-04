package com.powerjun.mybatis.mymybatis;

/**
 * @author Jim
 * @date 2019/6/4
 */
public final class MySqlSessionFactoryBuilder {
    private String baseMapperPackage;
    private String url;
    private String username;
    private String password;

    private MySqlSessionFactoryBuilder() {
    }

    public static MySqlSessionFactoryBuilder aMySqlSessionFactory() {
        return new MySqlSessionFactoryBuilder();
    }

    public MySqlSessionFactoryBuilder withBaseMapperPackage(String baseMapperPackage) {
        this.baseMapperPackage = baseMapperPackage;
        return this;
    }

    public MySqlSessionFactoryBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public MySqlSessionFactoryBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public MySqlSessionFactoryBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public MySqlSessionFactory build() {
        MySqlSessionFactory mySqlSessionFactory = new MySqlSessionFactory();
        mySqlSessionFactory.setBaseMapperPackage(baseMapperPackage);
        mySqlSessionFactory.setUrl(url);
        mySqlSessionFactory.setUsername(username);
        mySqlSessionFactory.setPassword(password);
        mySqlSessionFactory.init();
        return mySqlSessionFactory;
    }
}
