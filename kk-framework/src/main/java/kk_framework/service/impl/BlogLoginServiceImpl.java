package kk_framework.service.impl;

import kk_framework.entity.LoginUser;
import kk_framework.entity.User;
import kk_framework.response.ResponseResult;
import kk_framework.service.BlogLoginService;
import kk_framework.response.utils.BeanCopyUtils;
import kk_framework.response.utils.JwtUtil;
import kk_framework.response.utils.RedisCache;
import kk_framework.vo.BlogUserLoginVO;
import kk_framework.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.management.relation.RelationSupport;
import java.util.Objects;

@Service
@Slf4j
public class BlogLoginServiceImpl implements BlogLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private RedisCache redisCache;
    @Override

    public ResponseResult login(User user) {

        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
//        log.info("token是"+authenticationToken.toString());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        LoginUser loginUser= (LoginUser) authenticate.getPrincipal();
        String id = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(id);

        //存入redis
        redisCache.setCacheObject("bloglogin:"+id,loginUser);

        UserInfoVO userInfoVO = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVO.class);
        BlogUserLoginVO vo=new BlogUserLoginVO(jwt,userInfoVO);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult logout() {

        //获取token,解析获取userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //获取userid
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();

        Long userId=loginUser.getUser().getId();

        //删除redis中的用户信息
        redisCache.deleteObject("bloglogin"+userId);
        return ResponseResult.okResult();
    }
}
