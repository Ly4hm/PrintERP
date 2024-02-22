package com.lyahm.erp.controller;

import com.lyahm.erp.popj.Inventory;
import com.lyahm.erp.popj.Result;
import com.lyahm.erp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventory_service;

    @RequestMapping("/findInventoryById")
    public Result findById(Integer id) {
        Inventory data = inventory_service.findById(id);
        return new Result(1, "success", data);
    }
}
