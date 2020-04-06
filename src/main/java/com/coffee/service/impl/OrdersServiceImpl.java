package com.coffee.service.impl;

import com.coffee.entity.OrdersEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.OrdersMapper;
import com.coffee.service.OrdersService;

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

    @Override
    public int updateOrder(OrdersEntity ordersEntity) {
        return ordersMapper.updateByPrimaryKeySelective(ordersEntity);
    }

    @Override
    public PageInfo<OrdersEntity> selectOrder(OrdersEntity ordersEntity) {
        PageHelper.startPage(ordersEntity.getCurrentPage(),ordersEntity.getPageSize());
        List<OrdersEntity> list = ordersMapper.selectOrder(ordersEntity);
        return new PageInfo<>(list);
    }
}
