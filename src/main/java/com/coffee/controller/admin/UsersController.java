package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.entity.AdminEntity;
import com.coffee.entity.UsersEntity;
import com.coffee.service.UsersService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : UsersController
 * @Description : 用户控制器
 * @Author : 王显成
 * @Date: 2019-12-19 14:20
 */
@Api(value = "UsersController",tags = "用户控制器")
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
    @PostMapping(value = "/addUser")
    public Result addUser(@RequestBody UsersEntity usersEntity){
        try {
            int users = usersService.addUser(usersEntity);
            if (users != 0){
                return Result.ok("添加成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("添加失败！");
    }

    /**
     * 根据用户 id 删除用户信息
     * @param userId 用户 id
     * @return 成功返回相应信息
     */
    @ApiOperation(value = "根据用户 id 删除用户信息",httpMethod = "POST")
    @ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "Integer")
    @PostMapping(value = "/deleteUser")
    public Result deleteUser(@RequestParam(value = "userId") Integer userId){
        try {
            int user = usersService.deleteUser(userId);
            if (user > 0){
                return Result.ok("删除成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("删除失败！");
    }

    /**
     *根据用户 id 修改用户信息
     * @param usersEntity 用户实体
     * @return
     */
    @ApiOperation(value = "根据用户 id 修改用户信息",httpMethod = "POST")
    @PostMapping(value = "/updateUser")
    public Result updateUser(@RequestBody UsersEntity usersEntity){
        try {
            int user = usersService.updateUser(usersEntity);
            if (user > 0){
                return Result.ok("修改成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("修改失败！");
    }

    /**
     * 根据条件查询用户相应的信息 (分页)
     * @param usersEntity 用户实体
     * @return
     */
    @ApiOperation(value = "根据条件查询用户相应的信息",httpMethod = "GET")
    @GetMapping(value = "/selectUser")
    public Result selectUser(UsersEntity usersEntity){
        try {
            //获取满足条件的分页信息
            PageInfo<UsersEntity> pageInfo = usersService.selectUser(usersEntity);
            //从分页信息中获取用户信息
            List<UsersEntity> list = pageInfo.getList();
            if (list.size() > 0 && list !=null){
                Map<String, Object> map = new HashMap<>();
                map.put("dataList",list);
                //获取总页数，总条数，当前页数
                map.put("pages",pageInfo.getPages());
                map.put("total",pageInfo.getTotal());
                map.put("pageNum",pageInfo.getPageNum());
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到用户信息！");
    }

    /**
     * 管理员登录
     * @param id 管理员 id
     * @param pwd 管理员密码
     * @return 成功返回管理员信息
     */
    @ApiOperation(value = "管理员密码",httpMethod = "GET")
    @GetMapping(value = "/adminLogin")
    public Result adminLogin(@RequestParam(value = "id") Integer id,@RequestParam(value = "pwd") String pwd){
        try {
            AdminEntity adminEntity = usersService.adminLogin(id, pwd);
            if (adminEntity != null){
                Map<String, Object> map = new HashMap<>();
                map.put("admin",adminEntity);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("此管理员不存在!");
    }
}
