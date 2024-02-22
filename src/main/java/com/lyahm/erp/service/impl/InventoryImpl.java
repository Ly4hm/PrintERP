package com.lyahm.erp.service.impl;

import com.lyahm.erp.mapper.InventoryMapper;
import com.lyahm.erp.popj.Inventory;
import com.lyahm.erp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventory_mapper;

    @Override
    public Inventory findById(Integer id) {
        return inventory_mapper.findById(id);
    }
}
