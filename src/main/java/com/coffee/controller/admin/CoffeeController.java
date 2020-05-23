package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.entity.CoffeeEntity;
import com.coffee.entity.StocksEntity;
import com.coffee.service.CoffeeService;
import com.coffee.service.StocksService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
 * @ClassName : CoffeeController
 * @Description : 咖啡管理控制器
 * @Author : 王显成
 * @Date: 2020-02-16 16:44
 */
@Api(value = "CoffeeController",tags = "咖啡控制器")
@RestController
@RequestMapping(value = "/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private StocksService stocksService;

    /**
     * 添加咖啡员信息
     * @param coffeeEntity 咖啡实体
     * @return
     */
    @ApiOperation(value = "添加咖啡信息",httpMethod = "POST")
    @PostMapping(value = "/addCoffee")
    public Result addCoffee(@RequestBody CoffeeEntity coffeeEntity){
        try {
            StocksEntity stocksEntity = new StocksEntity();
            int stocks = stocksService.addStocks(stocksEntity);
            if (stocks > 0){
                //获得库存自增长 id
                Integer stockId = stocksEntity.getStockId();
                coffeeEntity.setStockId(stockId);
                coffeeService.addCoffee(coffeeEntity);
                //获得咖啡自增长 id
                Integer coffeeId = coffeeEntity.getCoffeeId();
                stocksEntity.setCoffeeId(coffeeId);
                stocksEntity.setStockId(stockId);
                //修改库存表咖啡id
                stocksService.updateStocks(stocksEntity);
                return Result.ok("添加成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("添加失败!");
    }

    /**
     * 根据id删除咖啡信息
     * @param coffeeId 咖啡 id
     * @return
     */
    @ApiOperation(value = "删除咖啡信息",httpMethod = "POST")
    @ApiImplicitParam(name = "coffeeId",value = "咖啡 id",required = true,dataType = "Integer")
    @PostMapping(value = "/deleteCoffee")
    public Result deleteCoffee(Integer coffeeId){
        try {
            int i = coffeeService.deleteCoffee(coffeeId);
            if (i > 0){
                return Result.ok("删除成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("删除失败!");
    }

    /**
     * 修改咖啡信息
     * @param coffeeEntity 咖啡实体
     * @return
     */
    @ApiOperation(value = "修改咖啡信息",httpMethod = "POST")
    @PostMapping(value = "/updateCoffee")
    public Result updateCoffee(@RequestBody CoffeeEntity coffeeEntity){
        try{
            int i = coffeeService.updateCoffee(coffeeEntity);
            if (i>0){
                return Result.ok("修改成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("修改失败!");
    }

    /**
     * 查询满足条件的咖啡信息
     * @param coffeeEntity 查询条件
     * @return
     */
    @ApiOperation(value = "查询满足条件的咖啡信息",httpMethod = "GET")
    @GetMapping(value = "/selectCoffee")
    public Result selectCoffee(CoffeeEntity coffeeEntity){
        try{
            PageInfo<CoffeeEntity> pageInfo = coffeeService.selectCoffee(coffeeEntity);
            List<CoffeeEntity> list = pageInfo.getList();
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


}
