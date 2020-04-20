package com.dandan.controller;

import com.dandan.model.RespResult;
import com.dandan.pojo.GoodsCats;
import com.dandan.service.GoodCatService;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodcat")
public class GoodCatController {

    private final Logger logger = LoggerFactory.getLogger(GoodCatController.class);

    @Autowired
    GoodCatService goodCatService;

    @GetMapping("/allGoodCats")
    public RespResult allGoodCats(Integer shopId){
        try {
            return goodCatService.allGoodCats(shopId);
        }catch (Exception e){
            logger.error("[allGoodCats][exception] GoodCats exception : {}", "shopId: " + shopId + e.getMessage() );
        }
        return RespUtil.failResult("获取失败");
    }

    @PostMapping("/")
    public RespResult addGoodCats(GoodsCats goodsCats){
        try {
            return goodCatService.insertGoodCat(goodsCats);
        }catch (Exception e){
            logger.error("[allGoodCats][exception] GoodCats exception : {}", "shopId: " + goodsCats.getShopId() + e.getMessage() );
        }
        return RespUtil.failResult("添加失败");
    }

    @PutMapping("/")
    public RespResult updateGoodCats(GoodsCats goodsCats){
        try {
            return goodCatService.updateGoodCat(goodsCats);
        }catch (Exception e){
            logger.error("[updateGoodCats][exception] GoodCats exception : {}", "shopId: " + goodsCats.getShopId() + e.getMessage() );
        }
        return RespUtil.failResult("修改失败");
    }

    @DeleteMapping("/")
    public RespResult deleteGoodCats(Integer catId){
        try {
            return goodCatService.deleteGoodCat(catId);
        }catch (Exception e){
            logger.error("[deleteGoodCats][exception] GoodCats exception : {}", "catId: " + catId + e.getMessage() );
        }
        return RespUtil.failResult("删除失败");
    }
}
