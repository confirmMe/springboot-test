package com.ysw.demo1.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter run");
        filterChain.doFilter(servletRequest, servletResponse);//放行
    }

    @Override
    public void destroy() {

    }
}
