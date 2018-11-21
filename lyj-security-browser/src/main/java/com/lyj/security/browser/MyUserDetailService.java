package com.lyj.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @auther lyj
 * @date 2018/11/21 0021 上午 8:12
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder  passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名："+username   );

        String password=passwordEncoder.encode("123456");
        logger.info("数据库密码是"+password);
        //根据用户名查找用户信息；在实际开发中要从你的数据库里读出来的；框架会帮你进行验证；
        return new User(username, password,true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

    }
}
