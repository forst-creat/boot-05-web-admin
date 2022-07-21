package com.atguigu.admin.service;

import com.atguigu.admin.bean.City;

/**
 * @author liuyang
 * @create 2022-07-19-8:10
 */
public interface CityService {

    public City getCityById(Long id);

    public void saveCity(City city);
}
