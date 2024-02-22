package com.lyahm.erp.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.lyahm.erp.popj.Result;
import com.lyahm.erp.popj.User;
import com.lyahm.erp.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{2,5}$") String username,
                           @Pattern(regexp = "^\\S{32}$") String password,
                           @Pattern(regexp = "^\\S{11}$") String phone,
                           Integer access) {
        User u = userService.findByUsername(username);
        // 是否注册
        if (u == null) {
            // 注册
            userService.register(username, password, phone, access);
            return Result.success();
        } else {
            return Result.error("用户已注册");
        }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{2,5}$") String username,
                        @Pattern(regexp = "^\\S{32}$") String password) {
        if (userService.checkPw(username, password)) {
            StpUtil.login(username);
            return Result.success();
        } else {
            return Result.error("密码错误");
        }
    }

    @RequestMapping("/userinfo")
    public Result userinfo(@Pattern(regexp = "^\\S{2,5}$") String username) {
        // 查询的信息非当前用户信息时
        if (!StpUtil.getLoginId().equals(username)) {
            return Result.error("仅可查询个人信息");
        }

        User u = userService.getUserInfo(username);
        return new Result<User>(0, "查询成功", u);
    }
}
