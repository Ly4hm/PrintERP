package com.lyahm.erp.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.lyahm.erp.popj.Result;
import com.lyahm.erp.popj.Suborder;
import com.lyahm.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SaCheckLogin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/suborder")
    public Result getSubOrder(Integer order_id) {
        List<Suborder> suborders = orderService.getSuborderByOrder(order_id);
        return Result.success(suborders);
    }
}
