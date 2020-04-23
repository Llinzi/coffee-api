package com.coffee.service;

import com.coffee.entity.AdminEntity;
import com.coffee.entity.UsersEntity;
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

    /**
     * 管理员登录
     * @param id 管理员 id
     * @param pwd 管理员密码
     * @return 成功返回管理员信息
     */
    AdminEntity adminLogin(Integer id, String pwd);

    /**
     * 用户登录
     * @param userPhone 用户手机号
     * @param userPassword 用户密码
     * @return 成功发回用户信息
     */
    UsersEntity userLogin(String userPhone,String userPassword);

    /**
     * 查询此号码是否存在
     * @param userPhone 用户号码
     * @return
     */
    UsersEntity selectPhone(String userPhone);

    /**
     * 根据手机号修改用户密码
     * @param userPhone 手机号
     * @param userPassword 密码
     * @return
     */
    int updatePwd(String userPhone,String userPassword);

}
