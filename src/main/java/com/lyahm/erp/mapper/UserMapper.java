package com.lyahm.erp.mapper;

import com.lyahm.erp.popj.Result;
import com.lyahm.erp.popj.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Select("insert into user(username, password, phone, create_time, update_time, access)" +
            " VALUES(#{username}, #{encryptPw}, #{phone}, now(), now(), #{access})")
    void add(String username, String encryptPw, String phone, Integer access);

    @Select("select password from user where username=#{username}")
    String getPw(String username);

    @Select("select username, phone, access, update_time from user where username=#{username}")
    User getUserInfo(String username);
}
