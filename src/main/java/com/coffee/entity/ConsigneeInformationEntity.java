package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
* @ClassName : ConsigneeInformation
* @Description : 收货人地址管理实体类
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
@Data
@Table(name = "consignee_information")
public class ConsigneeInformationEntity implements Serializable {
    /**
     * 收货人编号
     */
    @Id
    @Column(name = "consignee_information_id")
    @GeneratedValue(generator = "JDBC")
    private Integer consigneeInformationId;

    /**
     * 用户id
     */
    @Transient
    @Column(name = "userId")
    private Integer userId;

    /**
     * 收货人姓名
     */
    @Column(name = "consignee_information_name")
    private String consigneeInformationName;

    /**
     * 收货人地址
     */
    @Column(name = "consignee_information_site")
    private String consigneeInformationSite;

    /**
     * 收货人电话
     */
    @Column(name = "consignee_information_phone")
    private String consigneeInformationPhone;

    private static final long serialVersionUID = 1L;
}