package com.powerjun.mybatis.mymybatis.mapper;

import com.powerjun.mybatis.model.Country;
import com.powerjun.mybatis.mymybatis.MySelect;

import java.util.List;

/**
 * @author Jim
 * @date 2019/6/4
 */
public interface MyCountryMapper {
    @MySelect(value = "select id, countryname, countrycode from country", returnType = Country.class)
    List<Country> selectAll();

    @MySelect(value = "select id, countryname, countrycode from country where countryname = ?", returnType = Country.class)
    List<Country> selectByName(String name);
}
