package com.zhang.client_mall.controller;

import com.zhang.client_mall.common.Constant;
import com.zhang.client_mall.common.ServerResponse;
import com.zhang.client_mall.common.SystemCode;
import com.zhang.client_mall.dto.UserDTO;
import com.zhang.client_mall.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserApi {

    @PostMapping("/login")
    public ServerResponse login(UserDTO userDTO, HttpSession session){
        log.info("md5加密：{}", MD5Util.MD5EncodeUtf8(userDTO.getPhone()));

        if (Constant.LOGIN.PHONE.equals(userDTO.getPhone())&&Constant.LOGIN.PASSWORD.equals(userDTO.getPassword())){
            session.setAttribute("user",userDTO);
            return ServerResponse.success();
        }
        return ServerResponse.fail(SystemCode.ERROR);
    }
}
