package com.powerjun.mybatis.mapper;

import com.powerjun.mybatis.model.Country;

import java.util.List;

/**
 * @author Jim
 * @date 2019/6/3
 */
public interface CountryMapper {
    Country selectById(int id);

    List<Country> selectAll();

    void updateCountry(Country country);
}
