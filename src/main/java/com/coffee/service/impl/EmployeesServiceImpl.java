package com.coffee.service.impl;

import com.coffee.entity.EmployeesEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.EmployeesMapper;
import com.coffee.service.EmployeesService;

import java.util.List;

/**
* @ClassName : EmployeesServiceImpl
* @Description : 销售员事务层实现类
* @Author : 王显成 
* @Date: 2020-02-11 19:08
*/
@Service
public class EmployeesServiceImpl implements EmployeesService{

    @Resource
    private EmployeesMapper employeesMapper;

    @Override
    public int addEmployees(EmployeesEntity employeesEntity) {
        employeesEntity.setEmployeesResult(0);
        return employeesMapper.insertSelective(employeesEntity);
    }

    @Override
    public int deleteEmployees(Integer employeesId) {
        return employeesMapper.deleteByPrimaryKey(employeesId);
    }

    @Override
    public int updateEmployees(EmployeesEntity employeesEntity) {
        return employeesMapper.updateByPrimaryKeySelective(employeesEntity);
    }

    @Override
    public PageInfo<EmployeesEntity> selectEmployees(EmployeesEntity employeesEntity) {
        PageHelper.startPage(employeesEntity.getCurrentPage(),employeesEntity.getPageSize());
        List<EmployeesEntity> list = employeesMapper.selectEmployees(employeesEntity);
        return new PageInfo<>(list);
    }

    @Override
    public EmployeesEntity empLogin(String phone, String pwd) {
        return employeesMapper.empLogin(phone,pwd);
    }

    @Override
    public EmployeesEntity selectByPhone(String phone) {
        return employeesMapper.selectByPhone(phone);
    }
}
