package com.coffee.service;

import com.coffee.entity.UsersEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

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
    int addUser(UsersEntity usersEntity);

    /**
     * 根据 id 删除用户信息
     * @param userId 用户 id
     * @return
     */
    int deleteUser(Integer userId);

    /**
     * 根据 id 修改用户信息
     * @param usersEntity 用户实体
     * @return
     */
    int updateUser(UsersEntity usersEntity);

    /**
     * 根据条件查询用户相应信息
     * @param usersEntity
     * @return
     */
    PageInfo<UsersEntity> selectUser(UsersEntity usersEntity);

}
