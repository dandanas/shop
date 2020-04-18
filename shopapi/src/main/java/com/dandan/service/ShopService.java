package com.dandan.service;

import com.dandan.mapper.ShopMapper;
import com.dandan.model.RespResult;
import com.dandan.pojo.Shop;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    private final Logger logger = LoggerFactory.getLogger(ShopService.class);

    @Autowired
    ShopMapper shopMapper;

    public RespResult listShops(Integer userId, Integer shopId){
        List<Shop> shops = new ArrayList<>();
        try {
            if(shopId == null || shopId == 0){
                shops = shopMapper.allShops(userId);
            }else{
                shops.add(shopMapper.getShop(userId, shopId));
            }
        }catch (Exception e){
            logger.error("[listShops][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp(shops);
    }

    public RespResult insertShop(Shop shop){
        try {
            shopMapper.insertShop(shop);
        }catch (Exception e){
            logger.error("[insertShop][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }

    public RespResult updateShop(Shop shop){
        try {
            if(shopMapper.selectShopByShopId(shop.getShopId()) == null){
                return RespUtil.failResult("不存在该店铺");
            }
            if(shopMapper.selectShopByShopName(shop.getShopName(), shop.getShopId()) != null){
                return RespUtil.failResult("该店铺名已存在");
            }
            shopMapper.updateShop(shop);
        }catch (Exception e){
            logger.error("[updateShop][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }

    public RespResult deleteShop(Integer shopId){
        try {
            if(shopMapper.selectShopByShopId(shopId) == null){
                return RespUtil.failResult("不存在该店铺");
            }
            shopMapper.deleteShop(shopId);
        }catch (Exception e){
            logger.error("[deleteShop][exception]: {}",e.getMessage());
        }
        return RespUtil.successResp();
    }
}
