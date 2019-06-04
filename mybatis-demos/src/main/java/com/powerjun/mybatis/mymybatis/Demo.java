package com.powerjun.mybatis.mymybatis;

import com.powerjun.mybatis.model.Country;
import com.powerjun.mybatis.mymybatis.mapper.MyCountryMapper;

import java.util.List;

/**
 * @author Jim
 * @date 2019/6/4
 */
public class Demo {
    public static void main(String[] args) {
        MySqlSessionFactory mySqlSessionFactory = MySqlSessionFactoryBuilder.aMySqlSessionFactory()
                .withBaseMapperPackage("com.powerjun.mybatis.mymybatis.mapper")
                .withUrl("jdbc:mysql://localhost:3306/mytest?&serverTimezone=UTC")
                .withUsername("kiktech")
                .withPassword("kiktech")
                .build();

        MySqlSession mySqlSession = mySqlSessionFactory.openSession();
        MyCountryMapper mapper = mySqlSession.getMapper(MyCountryMapper.class);
        List<Country> countries = mapper.selectAll();
        System.out.println(countries);

        List<Country> countries1 = mapper.selectByName("美国");
        System.out.println(countries1);


    }
}
