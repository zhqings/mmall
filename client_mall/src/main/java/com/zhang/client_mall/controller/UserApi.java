package com.zhang.client_mall.controller;

import com.zhang.client_mall.common.Constant;
import com.zhang.client_mall.common.ServerResponse;
import com.zhang.client_mall.common.SystemCode;
import com.zhang.client_mall.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserApi {

    @PostMapping("/login")
    public ServerResponse login(UserDTO userDTO, HttpSession session){
        if (Constant.LOGIN.PHONE.equals(userDTO.getPhone())&&Constant.LOGIN.PASSWORD.equals(userDTO.getPassword())){
            session.setAttribute("user",userDTO);
            return ServerResponse.success();
        }
        return ServerResponse.fail(SystemCode.ERROR);
    }
}
