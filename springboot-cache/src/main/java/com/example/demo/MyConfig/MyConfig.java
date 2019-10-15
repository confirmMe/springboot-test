package com.example.demo.MyConfig;


import com.example.demo.Interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ysw on 2019/4/3.
 */
//@EnableWebMvc
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login");
//
//    }

    //配置特定请求-路径映射
//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocalResolver();
//    }
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }


}
