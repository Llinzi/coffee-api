package com.coffee.mapper;

import com.coffee.entity.CoffeeEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : CoffeeMapper
* @Description : 咖啡持久化层
* @Author : 王显成 
* @Date: 2020-02-15 16:12
*/
public interface CoffeeMapper extends Mapper<CoffeeEntity> {

    /**
     * 查询满足条件的咖啡信息
     * @param coffeeEntity
     * @return
     */
    List<CoffeeEntity> selectCoffee(CoffeeEntity coffeeEntity);

}