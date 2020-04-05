package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.entity.EmployeesEntity;
import com.coffee.service.EmployeesService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @ClassName : EmployeesController
 * @Description : 销售员控制器
 * @Author : 王显成
 * @Date: 2020-02-12 12:24
 */
@Api(value = "EmployeesController",tags = "销售员控制器")
@RestController
@RequestMapping(value = "/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    /**
     * 添加销售员信息
     * @param employeesEntity 销售员实体
     * @return
     */
    @ApiOperation(value = "添加销售员信息",httpMethod = "POST")
    @PostMapping(value = "/addEmployees")
    public Result addEmployees(@RequestBody EmployeesEntity employeesEntity){
        try {
            int i = employeesService.addEmployees(employeesEntity);
            if (i > 0){
                return Result.ok("添加成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("添加失败!");
    }

    /**
     * 根据id删除销售员
     * @param employeesId 销售员 id
     * @return
     */
    @ApiOperation(value = "删除销售员信息",httpMethod = "POST")
    @PostMapping(value = "/deleteEmployees")
    public Result deleteEmployees(@RequestParam Integer employeesId){
        try {
            int i = employeesService.deleteEmployees(employeesId);
            if (i > 0){
                return Result.ok("删除成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("删除失败!");
    }

    /**
     * 修改销售员信息
     * @param employeesEntity 销售员实体
     * @return
     */
    @ApiOperation(value = "修改销售员信息",httpMethod = "POST")
    @PostMapping(value = "/updateEmployees")
    public Result updateEmployees(@RequestBody EmployeesEntity employeesEntity){
        try{
            int i = employeesService.updateEmployees(employeesEntity);
            if (i>0){
                return Result.ok("修改成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("修改失败!");
    }

    /**
     * 查询满足条件的销售员信息
     * @param employeesEntity 查询条件
     * @return
     */
    @ApiOperation(value = "查询满足条件的销售员信息",httpMethod = "GET")
    @GetMapping(value = "/selectEmployees")
    public Result selectEmployees(EmployeesEntity employeesEntity){
        try{
            PageInfo<EmployeesEntity> pageInfo = employeesService.selectEmployees(employeesEntity);
            List<EmployeesEntity> list = pageInfo.getList();
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("dataList",list);
                map.put("pages",pageInfo.getPages());
                map.put("pageNum",pageInfo.getPageNum());
                map.put("total",pageInfo.getTotal());
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到满足条件的信息");
    }

    /**
     * 销售员登录
     * @param phone 电话
     * @param pwd 密码
     * @return
     */
    @ApiOperation(value = "销售员登陆",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone",value = "电话",required = true),
            @ApiImplicitParam(name = "pwd",value = "密码",required = true)
    })
    @GetMapping(value = "/empLogin")
    public Result empLogin(@RequestParam Integer phone,@RequestParam String pwd){
        try {
            EmployeesEntity entity1 = employeesService.empLogin(phone, pwd);
            EmployeesEntity entity2 = employeesService.selectByPhone(phone);
            if (entity1 != null){
                return Result.ok();
            }else if (entity1 == null && entity2 != null){
                return Result.error("密码错误!");
            }else if (entity2 == null){
                return Result.error("该销售员不存在!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("登录失败，未知异常!");
    }

}
