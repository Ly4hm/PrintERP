package com.lyahm.erp.mapper;

import com.lyahm.erp.popj.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface InventoryMapper {
    @Select("select * from inventory where material_id = #{id}")
    public Inventory findById(Integer id);
}
