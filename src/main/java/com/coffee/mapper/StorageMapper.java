package com.coffee.mapper;

import com.coffee.entity.StorageEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : StorageMapper
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
public interface StorageMapper extends Mapper<StorageEntity> {

    /**
     *
     * @param storageEntity
     * @return
     */
    List<StorageEntity> selectStorage(StorageEntity storageEntity);

}