package kk_framework.response.utils;

import kk_framework.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.security.auth.kerberos.KerberosKey;

public class SecurityUtils {

//   获取用户
    public static LoginUser getLoginUser(){
        return (LoginUser) getAuthentication().getPrincipal();
    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Boolean isAdmin(){
        Long id=getLoginUser().getUser().getId();
        return id!=null&&1L==id;
    }

    public static Long getUserId(){
        return getLoginUser().getUser().getId();
    }
}
