package com.lyj.service.impl;

import com.lyj.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @auther lyj
 * @date 2018/11/19 0019 下午 15:43
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello"+name;
    }
}
