package com.coffee.service.impl;

import com.coffee.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coffee.mapper.UsersMapper;
import com.coffee.service.UsersService;
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
    public int addUsers(UsersEntity usersEntity) {
        return usersMapper.insertSelective(usersEntity);
    }
}
