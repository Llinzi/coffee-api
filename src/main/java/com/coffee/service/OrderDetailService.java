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

    /**
     * 向购物车中添加订单明细
     *
     * @param userId      用户编号
     * @param orderDetailEntity 订单明细
     * @return 添加成功返回true,否则返回false
     */
    boolean addShopping(Integer userId,OrderDetailEntity orderDetailEntity);

    /**
     * 获得指定用户的购物车信息
     *
     * @param userId 用户 编号
     * @return 成功返回java.util.List类型的实例，否则返回null
     */
    List<OrderDetailEntity> selectShopping(Integer userId);

    /**
     * 删除指定用户购物车中的商品信息
     *
     * @param userId
     * @param orderDetailEntity
     * @return
     */
    boolean removeShopping(Integer userId,OrderDetailEntity orderDetailEntity);

}
