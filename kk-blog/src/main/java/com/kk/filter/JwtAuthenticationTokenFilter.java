package com.kk.filter;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.netty.util.internal.StringUtil;
import kk_framework.entity.LoginUser;
import kk_framework.enums.AppHttpCodeEnum;
import kk_framework.response.ResponseResult;
import kk_framework.response.utils.JwtUtil;
import kk_framework.response.utils.RedisCache;
import kk_framework.response.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        //获取请求头中的token
        String token = httpServletRequest.getHeader("token");

        //判断是否有token
        if(!StringUtils.hasText(token)){
            //如果没有token，说明无需登录，直接放行
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return ;
        }

        //解析获取userid,使用jwt工具类的方法
        Claims claims=null;
        try {
             claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            //token超时，
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return ;
        }
        String userId = claims.getSubject();
        //从redis中获取用户信息

        LoginUser loginUser = redisCache.getCacheObject("bloglogin" + userId);
        //存入SecurityContextHolder

        if(Objects.isNull(loginUser)){
            //提示登录过期
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return ;
        }
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(loginUser,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
