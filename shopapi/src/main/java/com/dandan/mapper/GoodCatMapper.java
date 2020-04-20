package com.dandan.mapper;

import com.dandan.pojo.GoodsCats;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodCatMapper {

    String getCatNameByCatId(@Param("catId") Integer catId);

    List<GoodsCats> allGoodCats(Integer shopId);

    void insertGoodCat(GoodsCats goodsCats);

    void updateGoodCat(GoodsCats goodsCats);

    void deleteGoodCat(Integer catId);

}
