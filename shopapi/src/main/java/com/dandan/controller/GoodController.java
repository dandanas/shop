package com.dandan.controller;

import com.dandan.model.RespResult;
import com.dandan.pojo.Good;
import com.dandan.service.GoodService;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/good")
public class GoodController {

    private final Logger logger = LoggerFactory.getLogger(GoodController.class);

    @Autowired
    GoodService goodService;

    @GetMapping("/")
    public RespResult getGoods(Integer goodId, Integer shopId){
        try {
            return goodService.getGoods(shopId, goodId);
        }catch (Exception e){
            logger.error("[allGoods][exception] Goods exception : {}", "shopId: " + shopId + e.getMessage() );
        }
        return RespUtil.failResult("获取失败");
    }

    @PostMapping("/")
    public RespResult addGood(Good good){
        try {
            return goodService.insertGood(good);
        }catch (Exception e){
            logger.error("[addGood][exception] Goods exception : {}", "shopId: " + good.getShopId() + e.getMessage() );
        }
        return RespUtil.failResult("添加失败");
    }

    @PutMapping("/")
    public RespResult updateGood(Good good){
        try {
            return goodService.updateGood(good);
        }catch (Exception e){
            logger.error("[updateGood][exception] Goods exception : {}", "shopId: " + good.getShopId() + e.getMessage() );
        }
        return RespUtil.failResult("修改失败");
    }

    @DeleteMapping("/")
    public RespResult deleteGood(Integer goodId){
        try {
            return goodService.deleteGood(goodId);
        }catch (Exception e){
            logger.error("[deleteGood][exception] Goods exception : {}", e.getMessage() );
        }
        return RespUtil.failResult("删除失败");
    }
}
