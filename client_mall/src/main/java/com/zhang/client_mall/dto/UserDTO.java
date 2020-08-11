package com.zhang.client_mall.dto;

import lombok.Data;

/**
 * @author zhang
 * @date 2020/8/11 15:33
 * @descript 用户登陆信息
 */
@Data
public class UserDTO {
    private String phone;
    private String password;
}
