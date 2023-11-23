package kk_framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kk_framework.mapper.UserMapper;
import kk_framework.entity.User;

import kk_framework.response.ResponseResult;
import kk_framework.service.UserService;
import kk_framework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.util.Assert;
import java.util.List;

/**
 * ?û??(User)表服务实现类
 *
 * @author makejava
 * @since 2023-08-06 19:54:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseResult register(User user) {
        userMapper.insert(user);
        return  ResponseResult.okResult();
    }
}


