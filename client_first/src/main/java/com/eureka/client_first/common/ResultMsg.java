package com.eureka.client_first.common;

import lombok.Data;

@Data
public class ResultMsg<T> {
    private Integer code;
    private String msg;
    private T data;
}
