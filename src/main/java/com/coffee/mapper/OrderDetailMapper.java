package com.coffee.mapper;

import com.coffee.entity.OrderDetailEntity;
import com.coffee.entity.OrdersEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : OrderDetailMapper
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-05 21:12
*/
public interface OrderDetailMapper extends Mapper<OrderDetailEntity> {

    /**
     * 通过订单号查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetailEntity> selectOrderDetail(Integer orderId);

    /**
     * 批量添加订单明细
     * @param ordersEntity
     * @return
     */
    int addOrderDetail(OrdersEntity ordersEntity);
}