package com.lyahm.erp.service;

import com.lyahm.erp.popj.Result;
import com.lyahm.erp.popj.User;

import java.util.Iterator;

public interface UserService {
    // 根据用户名查询用户
    User findByUsername(String username);

    // 注册用户
    void register(String username, String password, String phone, Integer access);

    boolean checkPw(String username, String password);

    User getUserInfo(String username);
}
