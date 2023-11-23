package com.kk.controller;

import io.netty.util.internal.StringUtil;
import kk_framework.entity.User;
import kk_framework.enums.AppHttpCodeEnum;
import kk_framework.exception.SystemException;
import kk_framework.response.ResponseResult;
import kk_framework.service.BlogLoginService;
import kk_framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloLoginController {


    @Autowired
    private BlogLoginService b_service;

    @Autowired
    private UserService userService;
    @PostMapping("login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //提示，必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
       return b_service.login(user);
    }

    @PostMapping("register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("logout")
    public ResponseResult logout(){
        return b_service.logout();
    }
}
