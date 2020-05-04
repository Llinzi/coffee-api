package com.coffee.controller.users;

import com.coffee.common.Result;
import com.coffee.entity.ConsigneeInformationEntity;
import com.coffee.service.ConsigneeInformationService;
import com.coffee.service.UsersService;
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
 * @ClassName : UserController
 * @Description : 前台用户操作控制器
 * @Author : 王显成
 * @Date: 2020-04-23 22:52
 */
@RestController
@RequestMapping(value = "/userOperation")
public class UserOperationController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ConsigneeInformationService consigneeInformationService;

    /**
     * 查询登录用户的收货地址
     * @param userId 用户 id
     * @return
     */
    @GetMapping(value = "/selectConsignee")
    public Result selectConsignee(@RequestParam Integer userId){
        try {
            List<ConsigneeInformationEntity> list = consigneeInformationService.selectConsignee(userId);
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("dataList",list);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("该用户没有添加收货地址！");
    }

    /**
     * 修改收货地址
     * @param consigneeInformationEntity 收货地址实体
     * @return
     */
    @PostMapping(value = "/updateConsignee")
    public Result updateConsignee(@RequestBody ConsigneeInformationEntity consigneeInformationEntity){
        try {
            int i = consigneeInformationService.updateConsignee(consigneeInformationEntity);
            if (i > 0){
                return Result.ok("修改地址成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("修改地址失败！");
    }
}
