package com.ysw.demomybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.ysw.demomybatis.Mapper")
public class DemoMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoMybatisApplication.class, args);
    }

}
