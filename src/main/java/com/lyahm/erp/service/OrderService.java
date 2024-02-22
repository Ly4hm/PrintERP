package com.lyahm.erp.service;

import com.lyahm.erp.popj.Suborder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    List<Suborder> getSuborderByOrder(Integer orderId);
}
