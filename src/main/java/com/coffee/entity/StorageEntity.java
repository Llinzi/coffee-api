package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

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
    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}