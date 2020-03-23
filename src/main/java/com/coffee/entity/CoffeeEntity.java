package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @ClassName : Coffee
* @Description : 咖啡实体类
* @Author : 王显成 
* @Date: 2020-02-15 16:12
*/
@ApiModel(discriminator = "咖啡返回对象")
@Data
@Table(name = "coffee")
public class CoffeeEntity implements Serializable {
    /**
     * 咖啡编号
     */
    @ApiModelProperty(value = "咖啡编号")
    @Id
    @Column(name = "coffee_id")
    @GeneratedValue(generator = "JDBC")
    private Integer coffeeId;

    /**
     * 咖啡名称
     */
    @ApiModelProperty(value = "咖啡名称")
    @Column(name = "coffee_name")
    private String coffeeName;

    /**
     * 咖啡价格
     */
    @ApiModelProperty(value = "咖啡价格")
    @Column(name = "coffee_prices")
    private Double coffeePrices;

    /**
     * 咖啡折扣价
     */
    @ApiModelProperty(value = "咖啡折扣价")
    @Column(name = "coffee_discount")
    private Double coffeeDiscount;

    /**
     * 咖啡状态(0上架，1下架)
     */
    @ApiModelProperty(value = "咖啡状态(0上架，1下架)")
    @Column(name = "coffee_status")
    private Integer coffeeStatus;

    /**
     * 咖啡库存id
     */
    @ApiModelProperty(value = "咖啡库存id")
    @Column(name = "stock_id")
    private Integer stockId;

    /**
     * 是否新品(0是，1否)
     */
    @ApiModelProperty(value = " 是否新品(0是，1否)")
    @Column(name = "coffee_is_new")
    private Integer coffeeIsNew;

    /**
     * 是否热卖(0是，1否)
     */
    @ApiModelProperty(value = "是否热卖(0是，1否)")
    @Column(name = "coffee_is_hot")
    private Integer coffeeIsHot;

    /**
     * 咖啡级别
     */
    @ApiModelProperty(value = "咖啡级别")
    @Column(name = "coffee_level")
    private Integer coffeeLevel;

    /**
     * 咖啡简介
     */
    @ApiModelProperty(value = "咖啡简介")
    @Column(name = "coffee_brief")
    private String coffeeBrief;

    /**
     * 咖啡详情
     */
    @ApiModelProperty(value = "咖啡详情")
    @Column(name = "coffee_details")
    private String coffeeDetails;

    /**
     * 咖啡图片
     */
    @ApiModelProperty(value = "咖啡图片")
    @Column(name = "coffee_photo")
    private String coffeePhoto;

    /**
     * 类别编号
     */
    @ApiModelProperty(value = "类别编号")
    @Column(name = "class_id")
    private Integer classId;

    /**
     * 查询条件（起始价格）
     */
    @ApiModelProperty(value = "查询条件（起始价格）")
    private Double startPrices;

    /**
     * 查询条件（终止价格）
     */
    @ApiModelProperty(value = "查询条件（终止价格）")
    private Double endPrices;

    /**
     * 每页条数
     */
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer currentPage;

    private static final long serialVersionUID = 1L;
}