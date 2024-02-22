package com.lyahm.erp.utils;

import cn.dev33.satoken.secure.BCrypt;

public class PwUtil {
    public static String encrypt(String passwd) {
        return BCrypt.hashpw(passwd, BCrypt.gensalt());
    }

    /**
     * 验证密码是否正确
     * @param passwd 提供的密码
     * @param encodedPassword 数据库中的加密密码
     * @return Boolean的结果
     */
    public static Boolean checkpw(String passwd, String encodedPassword) {
        return BCrypt.checkpw(passwd, encodedPassword);
    }

}
