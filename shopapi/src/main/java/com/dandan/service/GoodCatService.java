package com.dandan.service;

import com.dandan.mapper.GoodCatMapper;
import com.dandan.model.RespResult;
import com.dandan.pojo.GoodsCats;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodCatService {

    private final Logger logger = LoggerFactory.getLogger(GoodCatService.class);

    @Autowired
    GoodCatMapper goodCatMapper;

    public RespResult allGoodCats(Integer shopId){
        List<GoodsCats> goodsCats = new ArrayList<>();
        try {
            goodsCats = goodCatMapper.allGoodCats(shopId);
        }catch (Exception e){
            logger.error("[allGoodCats][exception] GoodsCat exception : {}", "shopId: " + shopId + " " + e.getMessage() );
        }
        return RespUtil.successResp(goodsCats);
    }

    public RespResult insertGoodCat(GoodsCats goodsCats){
        try {
            goodCatMapper.insertGoodCat(goodsCats);
        }catch (Exception e){
            logger.error("[insertGoodCat][exception] GoodsCat exception : {}", e.getMessage() );
        }
        return RespUtil.successResp();
    }

    public RespResult updateGoodCat(GoodsCats goodsCats){
        try {
            goodCatMapper.updateGoodCat(goodsCats);
        }catch (Exception e){
            logger.error("[updateGoodCat][exception] GoodsCat exception : {}", e.getMessage() );
        }
        return RespUtil.successResp();
    }

    public RespResult deleteGoodCat(Integer catId){
        try {
            goodCatMapper.deleteGoodCat(catId);
        }catch (Exception e){
            logger.error("[deleteGoodCat][exception] GoodsCat exception : {}", e.getMessage() );
        }
        return RespUtil.successResp();
    }
}
