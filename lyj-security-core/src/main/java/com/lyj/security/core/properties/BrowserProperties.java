package com.lyj.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther lyj
 * @date 2018/11/21 0021 下午 14:20
 */

public class BrowserProperties {
      private String loginpage="/lyj-signIn.html";

    public String getLoginpage() {
        return loginpage;
    }

    public void setLoginpage(String loginpage) {
        this.loginpage = loginpage;
    }
}
