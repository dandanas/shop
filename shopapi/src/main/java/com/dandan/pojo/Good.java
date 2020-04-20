package com.dandan.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {

    @JSONField(name = "goodId")
    private Integer goodId;

    @JSONField(name = "goodSn")
    private String goodSn;

    @JSONField(name = "goodName")
    private String goodName;

    @JSONField(name = "goodImg")
    private String goodImg;

    @JSONField(name = "shopId")
    private Integer shopId;

    @JSONField(name = "sale")
    private Integer sale;

    @JSONField(name = "saleTime")
    private Date saleTime;

    @JSONField(name = "costPrice")
    private Double costPrice;

    @JSONField(name = "sellingPrice")
    private Double sellingPrice;

    @JSONField(name = "quantity")
    private Integer quantity;

    @JSONField(name = "goodCatId")
    private Integer goodCatId;

    @JSONField(name = "sellingType")
    private Integer sellingType;
}
