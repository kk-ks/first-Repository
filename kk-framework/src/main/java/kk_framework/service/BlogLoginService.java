package kk_framework.service;

import kk_framework.entity.User;
import kk_framework.response.ResponseResult;

public interface BlogLoginService {
    ResponseResult login(User user);


    ResponseResult logout();
}
