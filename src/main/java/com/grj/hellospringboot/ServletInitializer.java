package com.grj.hellospringboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Description
 * @Author guorenjie
 * @Date 2020/4/22 12:43
 **/

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HellospringbootApplication.class);
    }

}
