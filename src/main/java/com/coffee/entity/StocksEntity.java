package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @ClassName : Stocks
* @Description : 库存实体
* @Author : 王显成 
* @Date: 2020-03-26 13:28
*/
@ApiModel(discriminator = "库存返回数据对象")
@Data
@Table(name = "stocks")
public class StocksEntity implements Serializable {
    /**
     * 库存编号
     */
    @ApiModelProperty(value = "库存编号")
    @Id
    @Column(name = "stock_id")
    @GeneratedValue(generator = "JDBC")
    private Integer stockId;

    /**
     * 咖啡编号
     */
    @ApiModelProperty(value = "咖啡编号")
    @Column(name = "coffee_id")
    private Integer coffeeId;

    /**
     * 咖啡库存数量
     */
    @ApiModelProperty(value = "咖啡库存数量")
    @Column(name = "stock_count")
    private Integer stockCount;

    /**
     * 库存更新时间
     */
    @ApiModelProperty(value = "库存更新时间")
    @Column(name = "update_time")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Column(name = "remark")
    private String remark;

    /**
     * 咖啡名称
     */
    @ApiModelProperty(value = "咖啡名称")
    private String coffeeName;

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