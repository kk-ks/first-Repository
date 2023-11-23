package kk_framework.service;

import com.baomidou.mybatisplus.extension.service.IService;

import kk_framework.entity.User;
import kk_framework.response.ResponseResult;

/**
 * ?û??(User)表服务接口
 *
 * @author makejava
 * @since 2023-08-06 19:54:07
 */
public interface UserService extends IService<User> {

    ResponseResult register(User user);
}


