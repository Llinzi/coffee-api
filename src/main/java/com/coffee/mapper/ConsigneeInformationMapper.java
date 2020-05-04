package com.coffee.mapper;

import com.coffee.entity.ConsigneeInformationEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : ConsigneeInformationMapper
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
public interface ConsigneeInformationMapper extends Mapper<ConsigneeInformationEntity> {

    /**
     * 查询登录用户的收货地址
     * @param userId 用户 id
     * @return
     */
    List<ConsigneeInformationEntity> selectConsignee(Integer userId);

}