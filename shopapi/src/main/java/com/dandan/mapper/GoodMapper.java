package com.dandan.mapper;

import com.dandan.pojo.Good;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodMapper {

    List<Good> allGoods(Integer shopId);

    Good getGoodsByGoodId(Integer shopId, Integer goodId);

    void insertGood(Good good);

    void updateGood(Good good);

    void deleteGood(Integer goodId);
}
