package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @ClassName : Orders
* @Description : 订单实体
* @Author : 王显成 
* @Date: 2020-04-05 21:11
*/
@ApiModel(discriminator = "订单返回数据对象")
@Data
@Table(name = "orders")
public class OrdersEntity implements Serializable {
    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "JDBC")
    private Integer orderId;

    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 员工编号
     */
    @ApiModelProperty(value = "员工编号")
    @Column(name = "employees_id")
    private Integer employeesId;

    /**
     * 收货人id
     */
    @ApiModelProperty(value = "收货人id")
    @Column(name = "consignee_information_id")
    private Integer consigneeInformationId;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间")
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 下单总额
     */
    @ApiModelProperty(value = "下单总额")
    @Column(name = "order_amount")
    private Double orderAmount;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 订单类型（1为用户订单，2为销售员订单）
     */
    @ApiModelProperty(value = "订单类型（1为用户订单，2为销售员订单）")
    @Column(name = "order_type")
    private Integer orderType;

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
    @ApiModelProperty(value = "开始时间（查询条件）")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    /**
     * 结束时间（查询条件）
     */
    @ApiModelProperty(value = "结束时间（查询条件）")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String userName;

    /**
     * 收货人姓名
     */
    @ApiModelProperty(value = "收货人姓名")
    private String consigneeInformationName;

    /**
     * 收货人地址
     */
    @ApiModelProperty(value = "收货人地址")
    private String consigneeInformationSite;

    /**
     * 员工姓名
     */
    @ApiModelProperty(value = "员工姓名")
    private String employeesName;

    /**
     * 保存当前订单的所有订单明细
     */
    @ApiModelProperty(value = "保存当前订单的所有订单明细")
    private List<OrderDetailEntity> orderDetailEntityList;

    private static final long serialVersionUID = 1L;
}