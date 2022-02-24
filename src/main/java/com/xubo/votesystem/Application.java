package com.xubo.votesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author xubo
 * @Date 2022/2/24 9:44
 * 投票系统
 * 实体类之间的关系紊乱 后期优化
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xubo.votesystem.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
