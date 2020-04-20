package com.dandan.mapper;

import com.dandan.pojo.InventoryDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryDetailMapper {

    List<InventoryDetail> getAllInventoryDetail(Integer goodId);

    void insertInventoryDetail(InventoryDetail inventoryDetail);
}
