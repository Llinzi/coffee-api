package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.entity.StocksEntity;
import com.coffee.entity.StorageEntity;
import com.coffee.service.StocksService;
import com.coffee.service.StorageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : StocksController
 * @Description : 库存,库存出入库管理控制器
 * @Author : 王显成
 * @Date: 2020-04-18 15:33
 */
@RestController
@RequestMapping(value = "/stocks")
public class StocksController {

    @Autowired
    private StocksService stocksService;

    @Autowired
    private StorageService storageService;

    /**
     * 查询咖啡库存
     * @param stocksEntity
     * @return
     */
    @GetMapping(value = "/selectStocks")
    public Result selectStocks(StocksEntity stocksEntity){
        try{
            PageInfo<StocksEntity> pageInfo = stocksService.selectStocks(stocksEntity);
            List<StocksEntity> list = pageInfo.getList();
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("dataList",list);
                map.put("total",pageInfo.getTotal());
                map.put("pages",pageInfo.getPages());
                map.put("pageNum",pageInfo.getPageNum());
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到满足条件的信息");
    }

  /*  *//**
     * 修改库存
     * @param stocksEntity
     * @return
     *//*
    @PostMapping(value = "/updateStocks")
    public Result updateStocks(@RequestBody StocksEntity stocksEntity){
        try{
            int i = stocksService.updateStocks(stocksEntity);
            if (i > 0){
                return Result.ok("库存更新成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("库存更新失败！");
    }*/

    /**
     * 查询咖啡库存出入库管理
     * @param storageEntity
     * @return
     */
    @GetMapping(value = "/selectStorage")
    public Result selectStorage(StorageEntity storageEntity){
        try{
            PageInfo<StorageEntity> pageInfo = storageService.selectStorage(storageEntity);
            List<StorageEntity> list = pageInfo.getList();
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("total",pageInfo.getTotal());
                map.put("pages",pageInfo.getPages());
                map.put("pageNum",pageInfo.getPageNum());
                map.put("dataList",list);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到满足条件的信息");
    }

    /**
     * 添加咖啡出入库管理
     * @param storageEntity
     * @return
     */
    @PostMapping(value = "/addStorage")
    public Result addStorage(@RequestBody StorageEntity storageEntity){
        try{
            int i = storageService.addStorage(storageEntity);
            if (i > 0){
                //更新库存
                StocksEntity stocksEntity = new StocksEntity();
                stocksEntity.setCoffeeId(storageEntity.getCoffeeId());
                stocksEntity.setUpdateTime(storageEntity.getCreateTime());
                if(storageEntity.getStorageType() == 0){
                    stocksEntity.setStockCount(storageEntity.getStorageNum());
                    stocksService.updateStocks(stocksEntity);
                    return Result.ok("添加入库成功！");
                }else {
                    //Integer storageNum = storageEntity.getStorageNum();
                    stocksEntity.setStockCount(-(storageEntity.getStorageNum()));
                    stocksService.updateStocks(stocksEntity);
                    return Result.ok("添加出库成功！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("添加失败！");
    }

}
