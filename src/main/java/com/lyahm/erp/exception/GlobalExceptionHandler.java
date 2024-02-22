package com.lyahm.erp.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.lyahm.erp.popj.Result;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 输入数据不符合规范时
    @ExceptionHandler(ConstraintViolationException.class)
    public Result ConstraintViolationHandler(Exception e) {
//        e.printStackTrace();
        return Result.error("操作失败");
    }

    // 未登录时
    @ExceptionHandler(NotLoginException.class)
    public Result NotLoginHandler() {
        return Result.error("请先登录");
    }


}
