package com.ysw.yswstarterautoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
//web容器下可用
@EnableConfigurationProperties(TestProperties.class)
//相当于@Comoant，将指定的配置文件装配入容器，否则配置文件的@ConfigurationProperties注解无法使用
public class TestAutoConfiguration {
    @Autowired
    TestProperties TestProperties;

    @Bean
    public TestService TestService() {
        TestService service = new TestService();
        //为功能实现类指定配置文件
        service.setTestProperties(TestProperties);
        return service;
    }
}
