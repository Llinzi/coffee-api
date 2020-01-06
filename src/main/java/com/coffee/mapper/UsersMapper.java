package com.coffee.mapper;

import com.coffee.entity.UsersEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : UsersMapper
* @Description : 用户mapper
* @Author : 王显成 
* @Date: 2019-12-19 13:54
*/
public interface UsersMapper extends Mapper<UsersEntity> {

    List<UsersEntity> selectUser(UsersEntity usersEntity);

    UsersEntity adminLogin(Integer userId,String userPassword);

}