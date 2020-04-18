package com.dandan.mapper;

import com.dandan.pojo.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopMapper {

    List<Shop> allShops(Integer userId);

    Shop getShop(Integer userId, Integer shopId);

    void insertShop(Shop shop);

    Shop selectShopByShopId(Integer ShopId);

    void updateShop(Shop shop);

    Shop selectShopByShopName(String shopName, Integer shopId);

    void deleteShop(Integer shopId);
}
