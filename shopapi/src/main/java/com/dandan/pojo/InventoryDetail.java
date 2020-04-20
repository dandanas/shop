package com.dandan.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDetail {

    @JSONField(name = "inventoryDetailId")
    private Integer inventoryDetailId;

    @JSONField(name = "goodId")
    private Integer goodId;

    @JSONField(name = "type")
    private Integer type;

    @JSONField(name = "quantity")
    private Integer quantity;

    @JSONField(name = "profit")
    private Double profit;
}
