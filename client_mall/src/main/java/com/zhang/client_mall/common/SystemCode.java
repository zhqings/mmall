package com.zhang.client_mall.common;
/**
 * @author zhang
 * @date 2020/8/11 15:14
 * @descript 统一返回参数
 */
public enum SystemCode {
    ERROR(-1, "程序异常"),
    SUCCESS(200,"成功");

    private final Integer code;
    private final String msg;

    SystemCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
