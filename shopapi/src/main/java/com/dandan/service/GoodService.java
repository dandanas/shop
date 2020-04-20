package com.dandan.service;

import com.dandan.dto.GoodDTO;
import com.dandan.mapper.GoodCatMapper;
import com.dandan.mapper.GoodMapper;
import com.dandan.model.RespResult;
import com.dandan.pojo.Good;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {

    private final Logger logger = LoggerFactory.getLogger(GoodService.class);

    @Autowired
    GoodMapper goodMapper;

    @Autowired
    GoodCatMapper goodCatMapper;

    public RespResult getGoods(Integer shopId, Integer goodId){
        List<GoodDTO> goodsDTO = new ArrayList<>();
        try {
            List<Good> goods = new ArrayList<>();
            System.out.println("goodId " + goodId);
            if(goodId == null || goodId == 0){
                goods = goodMapper.allGoods(shopId);
            }else{
                goods.add(goodMapper.getGoodsByGoodId(goodId));
            }
            for (Good good : goods){
                GoodDTO goodDTO = new GoodDTO();
                goodDTO.setGoodId(good.getGoodId());
                goodDTO.setGoodSn(good.getGoodSn());
                goodDTO.setGoodName(good.getGoodName());
                goodDTO.setGoodImg(good.getGoodImg());
                goodDTO.setShopId(good.getShopId());
                goodDTO.setSale(good.getSale());
                goodDTO.setSaleTime(good.getSaleTime());
                goodDTO.setCostPrice(good.getCostPrice());
                goodDTO.setSellingPrice(good.getSellingPrice());
                goodDTO.setQuantity(good.getQuantity());
                goodDTO.setGoodCatName(goodCatMapper.getCatNameByCatId(good.getGoodCatId()));
                switch (good.getSellingType()){
                    case 1:
                        goodDTO.setSellingType("计量");
                        break;
                    case 2:
                        goodDTO.setSellingType("计重 /500g");
                        break;
                    default:
                        break;
                }
                goodsDTO.add(goodDTO);
            }
        }catch (Exception e){
            logger.error("[allGoods][exception] Goods exception : {}", "shopId: " + shopId + " " + e.getMessage() );
        }
        return RespUtil.successResp(goodsDTO);
    }

    public RespResult insertGood(Good good){
        try {
            goodMapper.insertGood(good);
        }catch (Exception e){
            logger.error("[insertGood][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }

    public RespResult updateGood(Good good){
        try {
            goodMapper.updateGood(good);
        }catch (Exception e){
            logger.error("[updateGood][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }

    public RespResult deleteGood(Integer goodId){
        try {
            goodMapper.deleteGood(goodId);
        }catch (Exception e){
            logger.error("[deleteGood][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }

    //出库
    public RespResult outOdStock(Integer goodId, Integer quantity){
        try {
            Good good = goodMapper.getGoodsByGoodId(goodId);
            good.setQuantity(good.getQuantity() - quantity);
            goodMapper.updateQuantity(goodId, good.getQuantity());
        }catch (Exception e){
            logger.error("[outOdStock][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }

    //入库
    public RespResult wareHousing(Integer goodId, Integer quantity){
        try {
            Good good = goodMapper.getGoodsByGoodId(goodId);
            good.setQuantity(good.getQuantity() + quantity);
            goodMapper.updateQuantity(goodId, good.getQuantity());
        }catch (Exception e){
            logger.error("[wareHousing][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }

    public RespResult inventory(Integer goodId, Integer quantity){
        try {
            goodMapper.updateQuantity(goodId, quantity);
        }catch (Exception e){
            logger.error("[inventory][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }
}
