package com.coffee.service.impl;

import com.coffee.entity.OrderDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.OrderDetailMapper;
import com.coffee.service.OrderDetailService;

import java.util.List;

/**
* @ClassName : OrderDetailServiceImpl
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-05 21:12
*/
@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<OrderDetailEntity> selectOrderDetail(Integer orderId) {
        return orderDetailMapper.selectOrderDetail(orderId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addShopping(Integer userId, OrderDetailEntity orderDetailEntity) {
        try {
            ListOperations<String,OrderDetailEntity> opsForList = this.redisTemplate.opsForList();
            //创建redis数据库中保存数据的健
            String key = "user" + userId;
            //向购物车中添加数据
            //1.判断指定键的list的长度，获得（获得此用户购物车中订单明细的数量）
            Long size = opsForList.size(key);
            if(size == 0) {
                //当前用户的购物车为空，直接将订单明细存入list中即可
                opsForList.leftPush(key, orderDetailEntity);
            }else {
                //当前用户的购物车不为空，需要判断购物车中是否存在新购买的订单明细
                //1.获得redis中指定键的list中所有的数据
                List<OrderDetailEntity> list = opsForList.range(key, 0, -1);
                //2.在list中查找新的订单明细是否存在（再list集合中查找订单明细首次出现的位置，没找到返回-1）
                int indexOf = list.indexOf(orderDetailEntity);

                if(indexOf == -1) {
                    //在购物车中没有找到新购买的订单明细，直接将新的订单明细添加到redis中指定的list中即可
                    opsForList.leftPush(key,orderDetailEntity);
                }else {
                    //在购物车中找到了新购买订单明细
                    //获得redis中指定键list的第N个元素
                    OrderDetailEntity o = opsForList.index(key, indexOf);
                    Integer num1 = o.getTransactionCount();
                    Integer num2 = orderDetailEntity.getTransactionCount();
                    //修改订单明细的购买数量
                    o.setTransactionCount(num1 + num2);
                    //将修改后的订单明细重新放回到redis中指定键的list原来的位置
                    opsForList.set(key, indexOf, o);
                }
            }

            return true;
        } catch (Exception e) {

        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderDetailEntity> selectShopping(Integer userId) {
        ListOperations<String,OrderDetailEntity> opsForList = this.redisTemplate.opsForList();
        return opsForList.range("user"+userId, 0, -1);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean removeShopping(Integer userId, OrderDetailEntity orderDetailEntity) {
        ListOperations<String,OrderDetailEntity> opsForList = this.redisTemplate.opsForList();
        //根据用户编号生成redis中list集合对应的健
        String key = "user" + userId;
        //获得redis中指定健的list集合的长度
        Long size = opsForList.size(key);
        //如果list中没有元素，结束方法
        if(size == 0) {
            return false;
        }
        //获得list中所有的元素
        List<OrderDetailEntity> list = opsForList.range(key, 0, -1);
        //在list集合中查找参数首次出现的位置，没找到返回-1
        int indexOf = list.indexOf(orderDetailEntity);
        //如果在购物车没有找到指定的元素，结束方法
        if(indexOf == -1) {
            return false;
        }
        //将商品信息从list中移除
        list.remove(indexOf);
        this.redisTemplate.delete(key);
        for (OrderDetailEntity o : list) {
            opsForList.rightPush(key, o);
        }
        return true;
    }

}
