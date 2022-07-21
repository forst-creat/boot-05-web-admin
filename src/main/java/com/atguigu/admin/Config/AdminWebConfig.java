package com.atguigu.admin.Config;

import com.atguigu.admin.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器去实现HandlerInterceptor接口
 * 2、拦截器注册到容器中(实现WebMvcConfigurerd的addInterceptors)
 * 3、指定拦截规则【如果拦截所有，静态资源也会被拦截】
 * @EnableWebMvc注解表示全面接管
 * @author liuyang
 * @create 2022-07-03-20:42
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/**")//    "/**"也会将静态资源拦截
               .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sql");//放行的请求
    }

}
