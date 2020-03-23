package com.coffee.service;

import com.coffee.entity.CoffeeEntity;
import com.github.pagehelper.PageInfo;

/**
* @ClassName : CoffeeService
* @Description : 咖啡事务层
* @Author : 王显成 
* @Date: 2020-02-15 16:12
*/
public interface CoffeeService{

    /**
     * 添加咖啡信息
     * @param coffeeEntity 咖啡实体
     * @return
     */
    int addCoffee(CoffeeEntity coffeeEntity);

    /**
     * 删除咖啡信息
     * @param coffeeId 咖啡 id
     * @return
     */
    int deleteCoffee(Integer coffeeId);

    /**
     * 修改咖啡信息
     * @param coffeeEntity 咖啡实体
     * @return
     */
    int updateCoffee(CoffeeEntity coffeeEntity);

    /**
     * 查询满足条件的咖啡信息
     * @param coffeeEntity 咖啡实体
     * @return
     */
    PageInfo<CoffeeEntity> selectCoffee(CoffeeEntity coffeeEntity);

}
