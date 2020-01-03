package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @ClassName : Users
* @Description : ${description}
* @Author : 王显成 
* @Date: 2019-12-19 13:54
*/
@ApiModel(discriminator = "返回数据对象")
@Data
@Table(name = "users")
public class UsersEntity implements Serializable {
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Integer userId;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "用户性别")
    @Column(name = "user_sex")
    private Integer userSex;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    @Column(name = "user_birthday")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date userBirthday;

    /**
     * 电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱")
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Column(name = "user_hphoto")
    private String userHphoto;

    /**
     * 用户状态
     */
    @ApiModelProperty(value = "用户状态")
    @Column(name = "user_status")
    private Integer userStatus;

    /**
     * 权限编号
     */
    @ApiModelProperty(value = "权限编号")
    @Column(name = "jdiction_id")
    private Integer jdictionId;

    /**
     * 用户收货地址id
     */
    @ApiModelProperty(value = "用户收货地址id")
    @Column(name = "consignee_information_id")
    private Integer consigneeInformationId;

    private static final long serialVersionUID = 1L;
}