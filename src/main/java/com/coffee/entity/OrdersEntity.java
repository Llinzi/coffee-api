package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @ClassName : Orders
* @Description : 订单实体
* @Author : 王显成 
* @Date: 2020-04-05 21:11
*/
@Data
@Table(name = "orders")
public class OrdersEntity implements Serializable {
    /**
     * 订单编号
     */
    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "JDBC")
    private Integer orderId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 员工编号
     */
    @Column(name = "employees_id")
    private Integer employeesId;

    /**
     * 收货人id
     */
    @Column(name = "consignee_information_id")
    private Integer consigneeInformationId;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 下单总额
     */
    @Column(name = "order_amount")
    private Double orderAmount;

    /**
     * 订单状态
     */
    @Column(name = "order_status")
    private Integer orderStatus;

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

    /**
     * 开始时间（查询条件）
     */
    private Date startTime;

    /**
     * 结束时间（查询条件）
     */
    private Date endTime;

    /**
     * 用户姓名
     */
    private String userName;

    private static final long serialVersionUID = 1L;
}