package com.coffee.controller.users;

import com.coffee.common.Result;
import com.coffee.entity.OrderDetailEntity;
import com.coffee.entity.OrdersEntity;
import com.coffee.service.OrderDetailService;
import com.coffee.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : CoffeeOperationController
 * @Description : 咖啡、订单控制器
 * @Author : 王显成
 * @Date: 2020-05-08 21:12
 */
@RestController
@RequestMapping(value = "/coffeeOperation")
public class CoffeeOperationController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 添加订单与订单明细
     *
     * @param ordersEntity 视图层传递的json字符串
     * @return
     */
    @PostMapping(value="/addOrder")
    //@RequestBody:将视图层传递的json字符串转换为实体类
    public Result addOrder(@RequestBody OrdersEntity ordersEntity) {
        ordersEntity.setOrderTime(new Date());
        try {
            boolean b = this.ordersService.addOrder(ordersEntity);
            if(b) {
                Map<String,Object> map = new HashMap<>();
                map.put("orderId", ordersEntity.getOrderId());
                return Result.ok(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error("生成订单失败！");
    }

    /**
     * 向购物车中添加订单明细
     * @return
     */
    @RequestMapping(value="/addShopping")
    public Result addShopping(@RequestParam("userId") Integer userId, OrderDetailEntity orderDetailEntity) {
        try {
            boolean b = this.orderDetailService.addShopping(userId, orderDetailEntity);
            if(b) {
                return Result.ok("添加购物车成功！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error("添加购物车失败！！！");
    }

    /**
     * 获得指定用户编号的购物车
     *
     * @param userId 用户编号
     * @return
     */
    @RequestMapping(value="/selectAllShopping")
    public Result selectAllShopping(@RequestParam("userId") Integer userId) {
        try {
            List<OrderDetailEntity> list = this.orderDetailService.selectShopping(userId);
            if(list !=null) {
                Map<String,Object> map = new HashMap<>();
                map.put("shoppingList", list);
                return Result.ok(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error("获取购物车信息失败！！！");
    }

    /**
     * 移除购物车中指定的商品信息
     *
     * @return
     */
    @RequestMapping(value="/removeShopping")
    public Result removeShopping(@RequestParam("userId") Integer userId,OrderDetailEntity orderDetailEntity) {
        try {
            boolean b = this.orderDetailService.removeShopping(userId, orderDetailEntity);
            if(b) {
                return Result.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error("移除购物车中的商品失败!!!");
    }

    /**
     * 修改订单状态
     * @param ordersEntity
     * @return
     */
    @RequestMapping(value = "/updateOrder")
    public Result updateOrder(OrdersEntity ordersEntity){
        try {
            int i = ordersService.updateOrder(ordersEntity);
            if (i > 0){
                return Result.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }

}
