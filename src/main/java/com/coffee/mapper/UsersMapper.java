package com.coffee.mapper;

import com.coffee.entity.AdminEntity;
import com.coffee.entity.UsersEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : UsersMapper
* @Description : 用户持久化层
* @Author : 王显成 
* @Date: 2019-12-19 13:54
*/
public interface UsersMapper extends Mapper<UsersEntity> {

    List<UsersEntity> selectUser(UsersEntity usersEntity);

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