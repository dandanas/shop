package com.dandan.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shop {

    @JSONField(name = "shopId")
    private Integer shopId;

    @JSONField(name = "shopName")
    private String shopName;

    @JSONField(name = "shopAddress")
    private String shopAddress;

    @JSONField(name = "userId")
    private Integer userId;

    @JSONField(name = "enable")
    private Integer enable;
}
