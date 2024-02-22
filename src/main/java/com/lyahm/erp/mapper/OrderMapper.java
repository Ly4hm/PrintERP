package com.lyahm.erp.mapper;

import com.lyahm.erp.popj.Suborder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from suborder where order_id=#{orderId}")
    @Results({
            @Result(property = "suborderId", column = "suborder_id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "paperType", column = "paper_type"),
            @Result(property = "unitPrice", column = "unit_price"),
            @Result(property = "orderStatus", column = "order_status")
    })
    List<Suborder> getSuborderByOrder(Integer orderId);
}
