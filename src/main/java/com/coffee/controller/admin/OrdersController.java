package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.entity.OrderDetailEntity;
import com.coffee.entity.OrdersEntity;
import com.coffee.service.OrderDetailService;
import com.coffee.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : OrdersController
 * @Description : 订单控制器
 * @Author : 王显成
 * @Date: 2020-04-08 17:45
 */
@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 查询满足条件的订单信息
     * @param ordersEntity 订单实体
     * @return
     */
    @GetMapping(value = "/selectOrders")
    public Result selectOrders(@RequestBody OrdersEntity ordersEntity){
        try {
            PageInfo<OrdersEntity> pageInfo = ordersService.selectOrder(ordersEntity);
            List<OrdersEntity> list = pageInfo.getList();
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("total",pageInfo.getTotal());
                map.put("pageNum",pageInfo.getPageNum());
                map.put("pages",pageInfo.getPages());
                map.put("dataList",list);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到满足条件的订单信息!");
    }

    /**
     * 根据订单号查询订单详情
     * @param orderId
     * @return
     */
    @GetMapping(value = "/selectOrderDetail")
    public Result selectOrderDetail(@RequestParam Integer orderId){
        try {
            List<OrderDetailEntity> list = orderDetailService.selectOrderDetail(orderId);
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("dataList",list);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("查询订单详情失败");
    }

    
}
