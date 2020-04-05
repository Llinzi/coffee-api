package com.coffee.service.impl;

import com.coffee.entity.StocksEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.StocksMapper;
import com.coffee.service.StocksService;
/**
* @ClassName : StocksServiceImpl
* @Description : 库存事务层实现类
* @Author : 王显成 
* @Date: 2020-3-26 13:28
*/
@Service
public class StocksServiceImpl implements StocksService{

    @Resource
    private StocksMapper stocksMapper;

    @Override
    public int addStocks(StocksEntity stocksEntity) {
        return stocksMapper.insertSelective(stocksEntity);
    }

    @Override
    public int updateStocks(StocksEntity stocksEntity) {
        return stocksMapper.updateByPrimaryKeySelective(stocksEntity);
    }
}
