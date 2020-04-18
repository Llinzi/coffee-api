package com.coffee.mapper;

import com.coffee.entity.StocksEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : StocksMapper
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-3-26 13:28
*/
public interface StocksMapper extends Mapper<StocksEntity> {

    /**
     * 查询咖啡库存
     * @param stocksEntity
     * @return
     */
    List<StocksEntity> selectStocks(StocksEntity stocksEntity);

}