package com.coffee.service;

import com.coffee.entity.OrdersEntity;
import com.github.pagehelper.PageInfo;

/**
* @ClassName : OrdersService
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-05 21:11
*/
public interface OrdersService{

    /**
     * 修改订单
     * @param ordersEntity 订单实体
     * @return
     */
    int updateOrder(OrdersEntity ordersEntity);

    /**
     * 查询满足条件的订单
     * @param ordersEntity
     * @return
     */
    PageInfo<OrdersEntity> selectOrder(OrdersEntity ordersEntity);

}
