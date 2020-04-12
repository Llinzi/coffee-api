package com.coffee.service;

import com.coffee.entity.OrderDetailEntity;

import java.util.List;

/**
* @ClassName : OrderDetailService
* @Description : 订单详情事务层
* @Author : 王显成 
* @Date: 2020-04-05 21:12
*/
public interface OrderDetailService{

    /**
     * 通过订单号查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetailEntity> selectOrderDetail(Integer orderId);

}
