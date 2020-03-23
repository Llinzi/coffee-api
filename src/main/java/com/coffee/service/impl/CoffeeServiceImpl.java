package com.coffee.service.impl;

import com.coffee.entity.CoffeeEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.CoffeeMapper;
import com.coffee.service.CoffeeService;

import java.util.List;

/**
* @ClassName : CoffeeServiceImpl
* @Description : 事务层实现类
* @Author : 王显成 
* @Date: 2020-02-15 16:12
*/
@Service
public class CoffeeServiceImpl implements CoffeeService{

    @Resource
    private CoffeeMapper coffeeMapper;

    @Override
    public int addCoffee(CoffeeEntity coffeeEntity) {
        return coffeeMapper.insertSelective(coffeeEntity);
    }

    @Override
    public int deleteCoffee(Integer coffeeId) {
        return coffeeMapper.deleteByPrimaryKey(coffeeId);
    }

    @Override
    public int updateCoffee(CoffeeEntity coffeeEntity) {
        return coffeeMapper.updateByPrimaryKeySelective(coffeeEntity);
    }

    @Override
    public PageInfo<CoffeeEntity> selectCoffee(CoffeeEntity coffeeEntity) {
        PageHelper.startPage(coffeeEntity.getCurrentPage(),coffeeEntity.getPageSize());
        List<CoffeeEntity> list = coffeeMapper.selectCoffee(coffeeEntity);
        return new PageInfo<>(list);
    }
}
