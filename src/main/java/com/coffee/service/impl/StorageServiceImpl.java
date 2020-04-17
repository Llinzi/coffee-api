package com.coffee.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.StorageMapper;
import com.coffee.service.StorageService;
/**
* @ClassName : StorageServiceImpl
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
@Service
public class StorageServiceImpl implements StorageService{

    @Resource
    private StorageMapper storageMapper;

}
