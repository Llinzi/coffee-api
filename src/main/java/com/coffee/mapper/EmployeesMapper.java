package com.coffee.mapper;

import com.coffee.entity.EmployeesEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : EmployeesMapper
* @Description : 销售员持久化层
* @Author : 王显成 
* @Date: 2020-02-11 19:08
*/
public interface EmployeesMapper extends Mapper<EmployeesEntity> {

    /**
     * 查询满足条件的销售员信息
     * @param employeesEntity 销售员实体
     * @return
     */
    List<EmployeesEntity> selectEmployees(EmployeesEntity employeesEntity);

    /**
     * 销售员登录
     * @param phone 手机号
     * @param pwd 密码
     * @return
     */
    EmployeesEntity empLogin(Integer phone,String pwd);

    /**
     * 通过手机号查询销售员是否存在
     * @param phone
     * @return
     */
    EmployeesEntity selectByPhone(Integer phone);

}