package com.dandan.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsCats {

    @JSONField(name = "goodsCatId")
    private Integer goodsCatId;

    @JSONField(name = "goodsCatName")
    private String goodsCatName;

    @JSONField(name = "shopId")
    private Integer shopId;
}
