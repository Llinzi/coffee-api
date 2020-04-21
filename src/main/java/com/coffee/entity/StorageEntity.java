package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @ClassName : Storage
* @Description : 出入库管理实体类
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
@Data
@Table(name = "`storage`")
public class StorageEntity implements Serializable {
    /**
     * 出入库id
     */
    @Id
    @Column(name = "storage_id")
    @GeneratedValue(generator = "JDBC")
    private Integer storageId;

    /**
     * 咖啡 id
     */
    @Column(name = "coffee_id")
    private Integer coffeeId;

    /**
     * 出入库数量
     */
    @Column(name = "storage_num")
    private Integer storageNum;

    /**
     * 类型（0:入库，1:出库）
     */
    @Column(name = "storage_type")
    private Integer storageType;


    /**
     * 出入库时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "create_time")
    private Date createTime;

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