package com.grj.hellospringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author guorenjie
 */
@SpringBootApplication
public class HellospringbootApplication implements CommandLineRunner {
    protected Logger log =  LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化配置");
    }

    public static void main(String[] args) {
        SpringApplication.run(HellospringbootApplication.class, args);
    }
}
