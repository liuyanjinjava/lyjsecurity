package com.lyj.exception;

import lombok.Data;

/**
 * @auther lyj
 * @date 2018/11/20 0020 上午 9:17
 */
@Data
public class UserNotExistException extends RuntimeException{

    private String id;

    public UserNotExistException(String id){
        super("user not exist");
        this.id=id;
    }
}
