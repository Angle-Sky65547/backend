package com.neuedu.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 代表后台返回给前台的数据通用对象DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    public static final Integer OK = 20000; //正常
    public static final Integer AUTHENTICATED_FAILED = 40300; //没有权限
    public static final Integer NOT_LOGIN = 40100; //，没有登录
    public static final Integer SERVER_FAILED = 50000; //服务器内部错误

    public static <T> Result<T> getOk(T data) {
        return new Result<>(data, OK, "success");
    }

    public static <T> Result<T> getAuthFailed(String message) {
        return new Result<>(null, AUTHENTICATED_FAILED, message);
    }

    public static <T> Result<T> getServerFailed(String message) {
        return new Result<>(null, SERVER_FAILED, message);
    }

    public static <T> Result<T> getLoginFailed() {
        return new Result<>(null, NOT_LOGIN, "not login");
    }

    private T data;
    private Integer statusCode;
    private String message;
}
