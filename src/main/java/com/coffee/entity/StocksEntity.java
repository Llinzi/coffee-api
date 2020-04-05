package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
* @ClassName : Stocks
* @Description : 库存实体
* @Author : 王显成 
* @Date: 2020-03-26 13:28
*/
@Data
@Table(name = "stocks")
public class StocksEntity implements Serializable {
    /**
     * 库存编号
     */
    @Id
    @Column(name = "stock_id")
    @GeneratedValue(generator = "JDBC")
    private Integer stockId;

    /**
     * 咖啡编号
     */
    @Column(name = "coffee_id")
    private Integer coffeeId;

    /**
     * 咖啡库存数量
     */
    @Column(name = "stock_count")
    private Integer stockCount;

    /**
     * 库存更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    private static final long serialVersionUID = 1L;
}