package com.scorpio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice

public class ExceptionIntercepter {

    /**
     * ResponseStatus 返回状态
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response handleUserNotException(Exception e) {
        Response response = new Response();
        System.out.println("======================ControllerAdvice-----------------------");

        //业务异常
        if(e instanceof ApplicationException){
            ApplicationException exception = (ApplicationException)e;
            response.getStatus().setException(exception);

            //参数错误
        }else if(e instanceof ServletRequestBindingException){
            response.getStatus().setErrorCode(SysError.PARAMETER_ERR);

            //验证框架校验错误
        }else if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException ce = (MethodArgumentNotValidException)e;

            ApplicationException exception = new ApplicationException(SysError.PARAMETER_ERR);
            exception.setMsg(ce.getMessage());
            response.getStatus().setException(exception);
            //未知异常
        }else {
            log.error("未知错误: ", e);
            response.getStatus().setErrorCode(SysError.UNKNOWN);
        }

        return response;
    }
}
