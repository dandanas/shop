package com.dandan.service;

import com.dandan.mapper.InventoryDetailMapper;
import com.dandan.model.RespResult;
import com.dandan.pojo.InventoryDetail;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryDetailService {

    private final Logger logger = LoggerFactory.getLogger(InventoryDetailService.class);

    @Autowired
    InventoryDetailMapper inventoryDetailMapper;

    public RespResult getAllInventoryDetail(Integer goodId){
        List<InventoryDetail> inventoryDetailList = new ArrayList<>();
        try {
            inventoryDetailList = inventoryDetailMapper.getAllInventoryDetail(goodId);
        }catch (Exception e){
            logger.error("[getAllInventoryDetail][exception] InventoryDetail exception : {}", "goodId: " + goodId + " " + e.getMessage() );
        }
        return RespUtil.successResp(inventoryDetailList);
    }

    public RespResult insertInventoryDetail(InventoryDetail inventoryDetail){
        try {
            inventoryDetailMapper.insertInventoryDetail(inventoryDetail);
        }catch (Exception e){
            logger.error("[getAllInventoryDetail][exception] InventoryDetail exception : {}", "goodId: " + inventoryDetail.getGoodId() + " " + e.getMessage() );
        }
        return RespUtil.successResp();
    }
}
