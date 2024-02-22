package com.lyahm.erp.service.impl;

import com.lyahm.erp.mapper.OrderMapper;
import com.lyahm.erp.popj.Suborder;
import com.lyahm.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Suborder> getSuborderByOrder(Integer orderId) {
        List<Suborder> suborders = orderMapper.getSuborderByOrder(orderId);
        // TODO: 增加用户鉴权来决定返回的数据
        return suborders;
    }
}
