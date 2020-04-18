package com.dandan.controller;

import com.dandan.model.RespResult;
import com.dandan.pojo.Shop;
import com.dandan.service.ShopService;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    ShopService shopService;

    @GetMapping("/")
    public RespResult allShop(Integer userId, Integer shopId){
        try {
            return shopService.listShops(userId, shopId);
        }catch (Exception e){
            logger.error("[allShop][exception] Shop exception : {}", e.getMessage());
        }
        return RespUtil.failResult("获取失败");
    }

    @PostMapping("/")
    public RespResult addShop(Shop shop){
        try {
            return shopService.insertShop(shop);
        }catch (Exception e){
            logger.error("[addShop][exception] Shop exception : {}", e.getMessage());
        }
        return RespUtil.failResult("添加店铺失败");
    }

    @PutMapping("/")
    public RespResult updateShop(Shop shop){
        try {
            return shopService.updateShop(shop);
        }catch (Exception e){
            logger.error("[updateShop][exception] Shop exception : {}", e.getMessage());
        }
        return RespUtil.failResult("修改店铺失败");
    }

    @DeleteMapping("/")
    public RespResult deleteShop(Integer shopId){
        try {
            return shopService.deleteShop(shopId);
        }catch (Exception e){
            logger.error("[deleteShop][exception] Shop exception : {}", e.getMessage());
        }
        return RespUtil.failResult("删除店铺失败");
    }
}
