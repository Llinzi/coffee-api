package com.coffee.controller.users;

import com.alibaba.fastjson.JSONObject;
import com.coffee.common.RedisUtils;
import com.coffee.common.Result;
import com.coffee.common.SubMailUtils;
import com.coffee.entity.EmployeesEntity;
import com.coffee.entity.UsersEntity;
import com.coffee.service.EmployeesService;
import com.coffee.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName : LoginController
 * @Description : 登录页面控制器
 * @Author : 王显成
 * @Date: 2020-04-22 15:02
 */
@Api(value = "LoginController",tags = " 登录页面控制器")
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 用户登录
     * @param userPhone 用户手机号
     * @param userPassword 用户密码
     * @return
     */
    @ApiOperation(value = "用户登录",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "用户手机号", required = true),
            @ApiImplicitParam(name = "userPassword", value = "用户密码" , required = true)
    })
    @GetMapping(value = "/login")
    public Result login(@RequestParam(value = "userPhone") String userPhone,
                        @RequestParam(value = "userPassword") String userPassword){
        try {
            UsersEntity usersPhone = usersService.selectPhone(userPhone);
            UsersEntity usersEntity = usersService.userLogin(userPhone, userPassword);
            if(usersPhone == null){
                return Result.error("该用户不存在,请注册!");
            }else if (userPhone !=null && usersEntity == null){
                return Result.error("密码错误");
            }else if(usersEntity.getUserStatus() == 1){
                return Result.error("该用户已被禁用，请联系客服");
            } else if (usersEntity != null){
                Map<String,Object> map = new HashMap<>();
                map.put("user",usersEntity);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }

    /**
     * 员工登录
     * @param phone 手机号
     * @param password 密码
     * @return
     */
    @ApiOperation(value = "员工登录",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true),
            @ApiImplicitParam(name = "password", value = "密码" , required = true)
    })
    @GetMapping(value = "/empLogin")
    public Result empLogin(@RequestParam(value = "phone") String phone,
                           @RequestParam(value = "password") String password){
        try{
            EmployeesEntity employeesEntity1 = employeesService.selectByPhone(phone);
            EmployeesEntity employeesEntity2 = employeesService.empLogin(phone, password);
            if (employeesEntity1 == null){
                return Result.error("该员工不存在");
            }else if (employeesEntity1 != null && employeesEntity2 == null){
                return Result.error("密码错误");
            }else if (employeesEntity2.getEmployeesStatus() == 1){
                return Result.error("该员工已被禁用");
            }else if (employeesEntity2 != null){
                Map<String,Object> map = new HashMap<>();
                map.put("emp",employeesEntity2);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }

    /**
     * 发送短信验证码
     * @param phone 电话
     * @param type  验证码类型（reg:注册; reset:重置）
     * @return
     */
    @ApiOperation(value = "发送短信验证码",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "电话", required = true),
            @ApiImplicitParam(name = "type", value = "验证码类型（reg:注册; reset:重置）" , required = true)
    })
    @GetMapping(value = "/sendMsg")
    public Result sendMsg(@RequestParam(value = "phone") String phone,
                          @RequestParam(value = "type") String type){
        if (phone == "" && phone == null){
            return Result.error("请输入电话号码");
        }
        try {
            Jedis jedis = new Jedis("127.0.0.1",6379);
            String ping = jedis.ping();
            if (ping.equalsIgnoreCase("PONG")){
                String code =String.valueOf(new Random().nextInt(899999) + 100000);
                JSONObject vars = new JSONObject();
                vars.put("code",code);
                vars.put("time","5分钟");
                String project = "";
                switch (type){
                    case "reg":
                        project = "pM2He";
                        break;
                    case "reset":
                        project = "rsvRe1";
                        break;
                }
                try {
                    boolean message = SubMailUtils.sendMessage(phone, project, vars);
                    if (message){
                        //把验证码存入redis缓存，并设置过期时间
                        redisUtils.set(phone , code , 5);
                        return Result.ok();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            return Result.error("请打开缓存");
        }
        return Result.error("发送验证码失败！");
    }

    /**
     * 查询手机号是否被注册
     * @param userPhone 手机号码
     * @return 被注册返回 {"valid",false}  没有被注册返回 {"valid",true}
     */
    @ApiOperation(value = "查询手机号是否被注册",httpMethod = "GET")
    @ApiImplicitParam(name = "userPhone", value = "手机号码", required = true)
    @GetMapping(value = "/selectPhone")
    public JSONObject selectPhone(String userPhone){
        JSONObject result = new JSONObject();
        UsersEntity usersEntity = usersService.selectPhone(userPhone);
        if (usersEntity != null){
            result.put("valid",false);
            return result;
        }
        result.put("valid",true);
        return result;
    }

    /**
     * 查询手机号是否存在(重置密码)
     * @param userPhone 手机号码
     * @return 被注册返回 {"valid",true}  没有被注册返回 {"valid",false}
     */
    @ApiOperation(value = "查询手机号是否存在(重置密码)",httpMethod = "GET")
    @ApiImplicitParam(name = "userPhone", value = "手机号码", required = true)
    @GetMapping(value = "/selectPhone1")
    public JSONObject selectPhone1(String userPhone){
        JSONObject result = new JSONObject();
        UsersEntity usersEntity = usersService.selectPhone(userPhone);
        if (usersEntity != null){
            result.put("valid",true);
            return result;
        }
        result.put("valid",false);
        return result;
    }

    /**
     * 验证验证码是否正确
     * @param code 验证码
     * @return 正确返回 {"valid",true}  错误返回 {"valid",false}
     */
    @ApiOperation(value = "验证验证码是否正确",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "电话", required = true),
            @ApiImplicitParam(name = "code", value = "验证码" , required = true)
    })
    @GetMapping(value = "/validationCode")
    public JSONObject validationCode(String phone , String code){
        JSONObject result = new JSONObject();
        //获取缓存中的验证码
        Object reCode = redisUtils.get(phone);
        if (reCode !=null){
            if (reCode.toString().equals(code)){
                result.put("valid",true);
                return result;
            }
        }else {
            System.out.println("验证码失效");
            result.put("valid",false);
            return result;
        }
        result.put("valid",false);
        return result;
    }

    /**
     * 根据手机号修改密码
     * @param userPhone 手机号
     * @param pwd 密码
     * @return
     */
    @ApiOperation(value = "根据手机号修改密码",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "手机号", required = true),
            @ApiImplicitParam(name = "pwd", value = "密码" , required = true)
    })
    @PostMapping(value = "/updatePwd")
    public Result updatePwd(@RequestParam String userPhone ,
                            @RequestParam String pwd){
        try{
            int i = usersService.updatePwd(userPhone,pwd);
            if (i > 0 ){
                return Result.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }


}
