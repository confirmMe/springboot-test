package com.ysw.demo1.MyConfig;

import com.ysw.demo1.servlet.MyListener;
import com.ysw.demo1.servlet.Myfilter;
import com.ysw.demo1.servlet.Myservlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Configuration
public class MyServletConfig {

    //配置嵌入式的容器
    @Bean
    public EmbeddedServletContainerCustomizer EmbeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                configurableEmbeddedServletContainer.setPort(8080);
            }
        };
    }

    //注册servlet以及拦截路径
    @Bean
    public ServletRegistrationBean ServletRegistrationBean() {
        ServletRegistrationBean myServletRegistrationBean = new ServletRegistrationBean(new Myservlet(), "/me");
        return myServletRegistrationBean;
    }

    //注册filter以及拦截路径
    @Bean
    public FilterRegistrationBean FilterRegistrationBean() {
        FilterRegistrationBean FilterRegistrationBean = new FilterRegistrationBean();
        FilterRegistrationBean.setFilter(new Myfilter());
        //拦截所有请求
        FilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return FilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean mylisterner() {
        ServletListenerRegistrationBean res = new ServletListenerRegistrationBean(new MyListener());
        return res;
    }

}
