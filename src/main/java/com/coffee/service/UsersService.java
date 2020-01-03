package com.coffee.service;

import com.coffee.entity.UsersEntity;

/**
* @ClassName : UsersService
* @Description : 用户事务层接口
* @Author : 王显成 
* @Date: 2019-12-19 13:54
*/
public interface UsersService{
    /**
     * 添加用户信息
     * @param usersEntity
     * @return
     */
    int addUsers(UsersEntity usersEntity);

}
