package com.lyj.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @auther lyj
 * @date 2018/11/20 0020 上午 9:59
 */
//@Component
public class TimeFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start=new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter:"+(new Date().getTime()-start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destory");
    }
}
