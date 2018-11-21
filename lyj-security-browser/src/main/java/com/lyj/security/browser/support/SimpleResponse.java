package com.lyj.security.browser.support;

/**
 * @auther lyj
 * @date 2018/11/21 0021 下午 14:08
 */

public class SimpleResponse {

    public SimpleResponse(Object content){
        this.content=content;
    }
    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
