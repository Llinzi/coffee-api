package com.coffee.service.impl;

import com.coffee.entity.ConsigneeInformationEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.ConsigneeInformationMapper;
import com.coffee.service.ConsigneeInformationService;

import java.util.List;

/**
* @ClassName : ConsigneeInformationServiceImpl
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
@Service
public class ConsigneeInformationServiceImpl implements ConsigneeInformationService{

    @Resource
    private ConsigneeInformationMapper consigneeInformationMapper;

    @Override
    public List<ConsigneeInformationEntity> selectConsignee(Integer userId) {
        return consigneeInformationMapper.selectConsignee(userId);
    }

    @Override
    public int updateConsignee(ConsigneeInformationEntity consigneeInformationEntity) {
        return consigneeInformationMapper.updateByPrimaryKeySelective(consigneeInformationEntity);
    }
}
