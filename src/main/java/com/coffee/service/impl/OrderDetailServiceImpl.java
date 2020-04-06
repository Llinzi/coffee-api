package com.coffee.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.OrderDetailMapper;
import com.coffee.service.OrderDetailService;
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

}
