package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.entity.UsersEntity;
import com.coffee.service.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : UsersController
 * @Description : 用户控制器
 * @Author : 王显成
 * @Date: 2019-12-19 14:20
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 添加用户信息
     * @param usersEntity
     * @return 成功返回 0 ,失败返回失败信息
     */
    @ApiOperation(value = "添加用户信息")
    @PostMapping(value = "/addUsers")
    public Result addUsers(@RequestBody UsersEntity usersEntity){
        int users = usersService.addUsers(usersEntity);
        if (users != 0){
            return Result.ok();
        }
        return Result.error();
    }
}
