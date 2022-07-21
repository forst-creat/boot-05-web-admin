package com.atguigu.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author liuyang
 * @create 2022-07-07-20:48
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     *处理整个web controller的异常
     */
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handlerAirthException(Exception e) {
        log.error("异常是：{}" ,e);
        return "login";  //视图地址
    }
}
