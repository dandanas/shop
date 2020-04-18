package com.dandan.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class GoodsCats {

    @JSONField(name = "goodsCatId")
    private Integer goodsCatId;

    @JSONField(name = "goodsCatName")
    private String goodsCatName;
}
