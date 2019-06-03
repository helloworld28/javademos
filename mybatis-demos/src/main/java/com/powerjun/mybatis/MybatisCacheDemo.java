package com.powerjun.mybatis;

import com.powerjun.mybatis.mapper.CountryMapper;
import com.powerjun.mybatis.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.InputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

/**
 * 关于mybatis 的一二级缓存
 *
 * @author Jim
 * @date 2019/6/3
 */
@Test
public class MybatisCacheDemo {


    SqlSessionFactory sqlSessionFactory;


    @BeforeClass
    public void init() {
        InputStream mybatisInputStream = MybatisCacheDemo.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisInputStream);

        } finally {
        }
    }


    @Test
    public void testFirstLevelCacheExists() {
        //测试一级缓存存在
        SqlSession session = sqlSessionFactory.openSession();
        CountryMapper mapper = session.getMapper(CountryMapper.class);
        Country country = mapper.selectById(1);

        Country country2 = mapper.selectById(1);
        assertTrue(country == country2);

    }

    @Test
    public void testFirstLevelCacheLost() {
        //1级缓存当会话里更新重新,则会话的缓存将失效
        SqlSession session = sqlSessionFactory.openSession();
        CountryMapper mapper = session.getMapper(CountryMapper.class);
        Country country = mapper.selectById(1);

        country.setCountryname("22");
        mapper.updateCountry(country);


        Country country2 = mapper.selectById(1);
        assertTrue(country == country2);
    }

    @Test
    public void testSecondLevelCache() {
        //二级缓存就是允许缓存跨session,是因为缓存提供的可以读写的缓存所以是需要实体类实现serializable
        SqlSession session = sqlSessionFactory.openSession();
        CountryMapper mapper = session.getMapper(CountryMapper.class);
        Country country = mapper.selectById(1);
        country.setCountryname("BB");

        //在close时才会去缓存
        session.close();

        SqlSession session2 = sqlSessionFactory.openSession();
        CountryMapper mapper2 = session2.getMapper(CountryMapper.class);
        Country country2 = mapper2.selectById(1);

        //虽然第一个操作没有提交数据库,但缓存里的值也发生了变化
        assertTrue(country != country2);
        assertEquals(country2.getCountryname(), "BB");
    }

    @Test
    public void testSecondLevelCacheEviction() {
        //二级缓存,当发生了更新操作就会失败所有的二级缓存
        SqlSession session = sqlSessionFactory.openSession();
        CountryMapper mapper = session.getMapper(CountryMapper.class);
        Country country = mapper.selectById(1);
        Country country11 = mapper.selectById(2);
        country.setCountryname("BB");
        country11.setCountryname("new name");

        mapper.updateCountry(country);
        session.commit();
        session.close();

        SqlSession session2 = sqlSessionFactory.openSession();
        CountryMapper mapper2 = session2.getMapper(CountryMapper.class);
        Country country2 = mapper2.selectById(1);
        Country country22 = mapper2.selectById(2);

        //虽然第一个操作没有提交数据库,但缓存里的值也发生了变化
        assertTrue(country != country2);
        assertEquals(country2.getCountryname(), "BB");
        assertNotEquals(country22.getCountryname(), "new Name");
    }


}
