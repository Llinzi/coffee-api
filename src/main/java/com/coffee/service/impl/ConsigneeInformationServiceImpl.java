package com.coffee.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.ConsigneeInformationMapper;
import com.coffee.service.ConsigneeInformationService;
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

}
