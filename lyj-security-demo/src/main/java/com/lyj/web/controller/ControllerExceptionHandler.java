package com.lyj.web.controller;

import com.lyj.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther lyj
 * @date 2018/11/20 0020 上午 9:32
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR )
    public Map<String,Object> handleUserNotExistException(UserNotExistException ux){
        Map<String,Object> result=new HashMap<>();
        result.put("id",ux.getId());
        result.put("message",ux.getMessage());
        return result;

    }
}
