package com.lyj.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther lyj
 * @date 2018/11/21 0021 下午 14:20
 */
@ConfigurationProperties(prefix =  "lyj.security")
public class SecurityProperties {
    private BrowserProperties browser=new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
