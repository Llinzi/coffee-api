package com.coffee.service;

import com.coffee.entity.EmployeesEntity;
import com.github.pagehelper.PageInfo;

/**
* @ClassName : EmployeesService
* @Description : 销售员事务层
* @Author : 王显成 
* @Date: 2020-03-21 19:08
*/
public interface EmployeesService{

    /**
     * 添加销售员信息
     * @param employeesEntity 销售员实体
     * @return
     */
    int addEmployees(EmployeesEntity employeesEntity);

    /**
     * 根据销售员 id 删除销售员信息
     * @param employeesId 销售员 id
     * @return
     */
    int deleteEmployees(Integer employeesId);

    /**
     * 修改销售员信息
     * @param employeesEntity 销售员实体
     * @return
     */
    int updateEmployees(EmployeesEntity employeesEntity);

    /**
     * 查询满足条件的销售员信息
     * @param employeesEntity 销售员实体
     * @return
     */
    PageInfo<EmployeesEntity> selectEmployees(EmployeesEntity employeesEntity);

    /**
     * 销售员登录
     * @param phone 手机号
     * @param pwd 密码
     * @return
     */
    EmployeesEntity empLogin(String phone,String pwd);

    /**
     * 通过手机号查询销售员是否存在
     * @param phone
     * @return
     */
    EmployeesEntity selectByPhone(String phone);
}
