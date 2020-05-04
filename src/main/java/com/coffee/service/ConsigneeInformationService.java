package com.coffee.service;

import com.coffee.entity.ConsigneeInformationEntity;

import java.util.List;

/**
* @ClassName : ConsigneeInformationService
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
public interface ConsigneeInformationService{

    /**
     * 查询登录用户的收货地址
     * @param userId 用户 id
     * @return
     */
    List<ConsigneeInformationEntity> selectConsignee(Integer userId);

    /**
     * 修改收货地址
     * @param consigneeInformationEntity
     * @return
     */
    int updateConsignee(ConsigneeInformationEntity consigneeInformationEntity);

}
