package com.coffee.service.impl;

import com.coffee.entity.UsersEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coffee.mapper.UsersMapper;
import com.coffee.service.UsersService;

import java.util.List;

/**
* @ClassName : UsersServiceImpl
* @Description : 用户事务层实现类
* @Author : 王显成 
* @Date: 2019-12-19 13:54
*/
@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int addUser(UsersEntity usersEntity) {
        return usersMapper.insertSelective(usersEntity);
    }

    @Override
    public int deleteUser(Integer userId) {
        return usersMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateUser(UsersEntity usersEntity) {
        return usersMapper.updateByPrimaryKeySelective(usersEntity);
    }

    @Override
    public PageInfo<UsersEntity> selectUser(UsersEntity usersEntity) {
        //设置分页信息
        PageHelper.startPage(usersEntity.getCurrentPage(),usersEntity.getPageSize());
        //查询满足条件的用户信息
        List<UsersEntity> list = usersMapper.selectUser(usersEntity);
        //返回分页信息
        return new PageInfo<>(list);
    }

    @Override
    public UsersEntity adminLogin(Integer userId, String userPassword) {
        return usersMapper.adminLogin(userId,userPassword);
    }
}
