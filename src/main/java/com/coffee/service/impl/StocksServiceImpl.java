package com.coffee.service.impl;

import com.coffee.entity.StocksEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.StocksMapper;
import com.coffee.service.StocksService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Transactional
    @Override
    public int addStocks(StocksEntity stocksEntity) {
        stocksEntity.setCoffeeId(0);
        stocksEntity.setStockCount(0);
        stocksEntity.setUpdateTime(new Date());
        return stocksMapper.insertSelective(stocksEntity);
    }

    @Override
    public int updateStocks(StocksEntity stocksEntity) {
        return stocksMapper.updateStocks(stocksEntity);
    }

    @Override
    public PageInfo<StocksEntity> selectStocks(StocksEntity stocksEntity) {
        PageHelper.startPage(stocksEntity.getCurrentPage(),stocksEntity.getPageSize());
        List<StocksEntity> list = stocksMapper.selectStocks(stocksEntity);
        return new PageInfo<>(list);
    }
}
