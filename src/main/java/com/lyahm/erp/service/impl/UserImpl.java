package com.lyahm.erp.service.impl;

import com.lyahm.erp.mapper.UserMapper;
import com.lyahm.erp.popj.Result;
import com.lyahm.erp.popj.User;
import com.lyahm.erp.service.UserService;
import com.lyahm.erp.utils.PwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password, String phone, Integer access) {
        // 加密
        String encryptPw = PwUtil.encrypt(password);
        userMapper.add(username, encryptPw, phone, access);
    }

    @Override
    public boolean checkPw(String username, String password) {
        String encryptPw = userMapper.getPw(username);
        return PwUtil.checkpw(password, encryptPw);
    }

    @Override
    public User getUserInfo(String username) {
        return userMapper.getUserInfo(username);
    }
}
