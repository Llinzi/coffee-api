package com.coffee.service.impl;

import com.coffee.entity.OrderDetailEntity;
import com.coffee.entity.OrdersEntity;
import com.coffee.mapper.OrderDetailMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.OrdersMapper;
import com.coffee.service.OrdersService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @ClassName : OrdersServiceImpl
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-05 21:11
*/
@Service
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int updateOrder(OrdersEntity ordersEntity) {
        return ordersMapper.updateByPrimaryKeySelective(ordersEntity);
    }

    @Override
    @Transactional
    public boolean addOrder(OrdersEntity ordersEntity) {
        // 添加订单的信息
        ordersEntity.setOrderTime(new Date());
        int orderId = this.ordersMapper.insertSelective(ordersEntity);
        // 如果订单信息添加成功，才能添加订单明细信息
        if (orderId > 0) {
            Integer orderDetail = this.orderDetailMapper.addOrderDetail(ordersEntity);
            if (orderDetail > 0) {
                // 将redis中指定用户的购物车信息删除
                String key = "user" + ordersEntity.getUserId();
                ListOperations<String, OrderDetailEntity> opsForList = this.redisTemplate.opsForList();
                // 获得用户在redis中所有的购物车信息
                List<OrderDetailEntity> range = opsForList.range(key, 0, -1);
                // 获得用户需要结算购物车信息
                List<OrderDetailEntity> orderDetailList = ordersEntity.getOrderDetailEntityList();
                if (range.size() == orderDetailList.size()) {
                    // 当两个集合的长度相等，表示用户对购物车中所有的商品进行了结算
                    Boolean delete = this.redisTemplate.delete(key);
                    if (delete) {
                        return true;
                    }
                } else {
                    // 当两个集合的长度不相等时，从所有购物车中删除已结算的购物信息
                    for (OrderDetailEntity o : orderDetailList) {
                        int index = range.indexOf(o);
                        if (index != -1) {
                            range.remove(index);
                        }
                    }
                    this.redisTemplate.delete(key);
                    for (OrderDetailEntity o1 : range) {
                        opsForList.rightPush(key, o1);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public PageInfo<OrdersEntity> selectOrder(OrdersEntity ordersEntity) {
        PageHelper.startPage(ordersEntity.getCurrentPage(),ordersEntity.getPageSize());
        List<OrdersEntity> list = ordersMapper.selectOrder(ordersEntity);
        return new PageInfo<>(list);
    }
}
