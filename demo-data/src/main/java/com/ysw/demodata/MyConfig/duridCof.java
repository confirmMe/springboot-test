package com.ysw.demodata.MyConfig;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class duridCof {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource durid() {
        return new DruidDataSource();
    }

    //配置druid的监控
    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "950925");
        map.put("allow", "127.0.0.1");

        map.put("pany", "192.168.93.90");
        bean.setInitParameters(map);
        return bean;
    }

    //2.配置一个监控的filter
    @Bean
    public FilterRegistrationBean statFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map map = new HashMap<>();
        map.put("exclusions", "*.css,*.js,/druid/*");
        bean.setInitParameters(map);

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
