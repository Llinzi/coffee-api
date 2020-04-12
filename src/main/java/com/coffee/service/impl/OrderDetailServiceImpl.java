package com.coffee.service.impl;

import com.coffee.entity.OrderDetailEntity;
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

    @Override
    public List<OrderDetailEntity> selectOrderDetail(Integer orderId) {
        return orderDetailMapper.selectOrderDetail(orderId);
    }

}
