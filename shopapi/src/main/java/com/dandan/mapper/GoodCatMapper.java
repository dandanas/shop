package com.dandan.mapper;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodCatMapper {

    String getCatNameByCatId(@Param("catId") Integer catId);

}
