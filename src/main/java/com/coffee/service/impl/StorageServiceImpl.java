package com.coffee.service.impl;

import com.coffee.entity.StorageEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.StorageMapper;
import com.coffee.service.StorageService;

import java.util.List;

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

    @Override
    public PageInfo<StorageEntity> selectStorage(StorageEntity storageEntity) {
        PageHelper.startPage(storageEntity.getCurrentPage(),storageEntity.getPageSize());
        List<StorageEntity> list = storageMapper.selectStorage(storageEntity);
        return new PageInfo<>(list);
    }

    @Override
    public int addStorage(StorageEntity storageEntity) {
        return storageMapper.insertSelective(storageEntity);
    }
}
