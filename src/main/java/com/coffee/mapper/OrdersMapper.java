package com.coffee.mapper;

import com.coffee.entity.OrdersEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : OrdersMapper
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-05 21:11
*/
public interface OrdersMapper extends Mapper<OrdersEntity> {

    /**
     * 查询满足条件的订单信息
     * @param ordersEntity 订单实体
     * @return
     */
    List<OrdersEntity> selectOrder(OrdersEntity ordersEntity);

}