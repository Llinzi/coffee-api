package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @ClassName : Employees
* @Description : 销售员实体类
* @Author : 王显成 
* @Date: 2020-02-11 19:08
*/
@ApiModel(discriminator = "销售员返回数据对象")
@Data
@Table(name = "employees")
public class EmployeesEntity implements Serializable {
    /**
     * 员工编号
     */
    @ApiModelProperty(value = "员工编号")
    @Id
    @Column(name = "employees_id")
    @GeneratedValue(generator = "JDBC")
    private Integer employeesId;

    /**
     * 员工姓名
     */
    @ApiModelProperty(value = "员工姓名")
    @Column(name = "employees_name")
    private String employeesName;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    @Column(name = "employees_number")
    private String employeesNumber;

    /**
     * 员工年龄
     */
    @ApiModelProperty(value = "员工年龄")
    @Column(name = "employees_age")
    private Integer employeesAge;

    /**
     * 员工职位
     */
    @ApiModelProperty(value = "员工职位")
    @Column(name = "employees_job")
    private String employeesJob;

    /**
     * 员工性别 0为男 1为女
     */
    @ApiModelProperty(value = "员工性别 0为男 1为女")
    @Column(name = "employees_sex")
    private Integer employeesSex;

    /**
     * 员工工资
     */
    @ApiModelProperty(value = "员工工资")
    @Column(name = "employees_salary")
    private Double employeesSalary;

    /**
     * 员工状态 0为启用 1为禁用
     */
    @ApiModelProperty(value = "员工状态（0为启用 1为禁用）")
    @Column(name = "employees_status")
    private Integer employeesStatus;

    /**
     * 员工密码
     */
    @ApiModelProperty(value = "员工密码")
    @Column(name = "employees_password")
    private String employeesPassword;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    @Column(name = "employees_phone")
    private String employeesPhone;

    /**
     * 业绩
     */
    @ApiModelProperty(value = "业绩")
    @Column(name = "employees_result")
    private Integer employeesResult;

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