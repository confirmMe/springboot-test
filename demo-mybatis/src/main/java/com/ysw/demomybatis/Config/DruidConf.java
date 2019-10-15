package com.ysw.demomybatis.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConf {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource myDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123");
        bean.setInitParameters(map);
        return bean;
    }

    public FilterRegistrationBean statFilterBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map map = new HashMap<>();
        map.put("exclusions", "*.js,*.css,/druid/*");
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
