package com.coffee.service;

import com.coffee.entity.StorageEntity;
import com.github.pagehelper.PageInfo;

/**
* @ClassName : StorageService
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
public interface StorageService{

    /**
     * 查询咖啡出入库
     * @param storageEntity
     * @return
     */
    PageInfo<StorageEntity> selectStorage(StorageEntity storageEntity);

    /**
     * 添加出入库
     * @param storageEntity
     * @return
     */
    int addStorage(StorageEntity storageEntity);

}
