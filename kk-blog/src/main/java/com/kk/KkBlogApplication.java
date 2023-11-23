package com.kk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@MapperScan("kk_framework.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@ComponentScan(basePackages = {"kk_framework.service.impl","com.kk.controller","kk_framework.config","kk_framework.mapper","com.kk.config","kk_framework.response","kk_framework.handler",
                                "com.kk.filter"})
public class KkBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(KkBlogApplication.class,args);
    }
}
