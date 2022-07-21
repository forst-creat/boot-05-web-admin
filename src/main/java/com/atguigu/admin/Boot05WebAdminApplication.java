package com.atguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.atguigu.admin.mapper")
@ServletComponentScan(basePackages = "com.atguigu.admin")   //指定原生Servlet组件放在哪里
@SpringBootApplication
public class Boot05WebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(Boot05WebAdminApplication.class, args);
    }
}
