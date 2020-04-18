package com.coffee.service;

import com.coffee.entity.StocksEntity;
import com.github.pagehelper.PageInfo;

/**
* @ClassName : StocksService
* @Description : 库存事务处理
* @Author : 王显成 
* @Date: 2020-3-26 13:28
*/
public interface StocksService{

    /**
     * 添加库存
     * @param stocksEntity 库存实体
     * @return
     */
    int addStocks(StocksEntity stocksEntity);

    /**
     * 修改库存
     * @param stocksEntity
     * @return
     */
    int updateStocks(StocksEntity stocksEntity);

    /**
     * 查询咖啡库存
     * @param stocksEntity
     * @return
     */
    PageInfo<StocksEntity> selectStocks(StocksEntity stocksEntity);
}
