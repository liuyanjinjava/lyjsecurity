package com.lyj.web.async;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther lyj
 * @date 2018/11/20 0020 下午 15:44
 */
@Component
public class DeferredResultHolder {

    private Map<String, DeferredResult<String>> map=new HashMap<>();

    public Map<String,DeferredResult<String>> getMap(){
        return map;
    }

    public void setMap(Map<String,DeferredResult<String>> map){
        this.map=map;
    }



}
