package com.zhang.client_mall.common;

import lombok.Data;

/**
 * @author zhang
 * @date 2020/8/11 15:14
 * @descript 统一返回数据格式
 */
@Data
public class ServerResponse<T> {

    private Integer status;

    private String msg;

    private T data;

    private ServerResponse(SystemCode systemCode, T t) {
        this.status = systemCode.getCode();
        this.msg = systemCode.getMsg();
        this.data = t;
    }

    private ServerResponse(SystemCode systemCode) {
        this.status = systemCode.getCode();
        this.msg = systemCode.getMsg();
    }

    public static <T> ServerResponse<T> successByData(T t) {
        return new ServerResponse<>(SystemCode.SUCCESS, t);
    }

    public static <T> ServerResponse<T> success() {
        return new ServerResponse<>(SystemCode.SUCCESS);
    }

    public static <T> ServerResponse<T> fail(SystemCode systemCode) {
        return new ServerResponse<>(systemCode);
    }
}
