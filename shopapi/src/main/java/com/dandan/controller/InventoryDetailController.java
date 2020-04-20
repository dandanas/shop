package com.dandan.controller;

import com.dandan.model.RespResult;
import com.dandan.pojo.InventoryDetail;
import com.dandan.service.InventoryDetailService;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventoryDetail")
public class InventoryDetailController {

    private final Logger logger = LoggerFactory.getLogger(InventoryDetailController.class);

    @Autowired
    InventoryDetailService inventoryDetailService;

    @GetMapping("/all")
    public RespResult getAllInventoryDetail(Integer goodId){
        try {
            return inventoryDetailService.getAllInventoryDetail(goodId);
        }catch (Exception e){
            logger.error("[getAllInventoryDetail][exception] InventoryDetail exception : {}", e.getMessage());
        }
        return RespUtil.failResult("获取失败");
    }

    @PostMapping("/")
    public RespResult insertInventoryDetail(InventoryDetail inventoryDetail){
        try {
            return inventoryDetailService.insertInventoryDetail(inventoryDetail);
        }catch (Exception e){
            logger.error("[insertInventoryDetail][exception] InventoryDetail exception : {}", e.getMessage());
        }
        return RespUtil.failResult("添加失败");
    }
}
