package com.lyahm.erp.popj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings({"rawtypes", "unchecked"})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    /*
    状态码：
        0：成功
        1：失败
     */
    private int code;
    private String message;
    private T data;

    /* 快速构造成功响应 */
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "success", data);
    }

    /*
    最小结构构造器，仅用于表示状态时使用
     */
    public static Result success() {
        return new Result(0, "success", null);
    }

    public static Result error() {
        return new Result(1, "error", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
