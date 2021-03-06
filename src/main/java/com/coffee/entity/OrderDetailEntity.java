package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @ClassName : OrderDetail
* @Description : 订单明细实体
* @Author : 王显成 
* @Date: 2020-04-05 21:12
*/
@ApiModel(discriminator = "订单明细数据对象")
@Data
@Table(name = "order_detail")
public class OrderDetailEntity implements Serializable {
    /**
     * 订单明细编号
     */
    @ApiModelProperty(value = "订单明细编号")
    @Id
    @Column(name = "order_detail_id")
    @GeneratedValue(generator = "JDBC")
    private Integer orderDetailId;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 咖啡编号
     */
    @ApiModelProperty(value = "咖啡编号")
    @Column(name = "coffee_id")
    private Integer coffeeId;

    /**
     * 咖啡名称
     */
    @ApiModelProperty(value = "咖啡名称")
    @Column(name = "coffee_name")
    private String coffeeName;

    /**
     * 咖啡图片
     */
    @ApiModelProperty(value = "咖啡图片")
    @Column(name = "coffee_photo")
    private String coffeePhoto;

    /**
     * 成交价
     */
    @ApiModelProperty(value = "成交价")
    @Column(name = "transaction_price")
    private Double transactionPrice;

    /**
     * 成交数量
     */
    @ApiModelProperty(value = "成交数量")
    @Column(name = "transaction_count")
    private Integer transactionCount;

    private static final long serialVersionUID = 1L;
}