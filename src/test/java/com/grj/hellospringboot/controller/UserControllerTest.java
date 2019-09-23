package com.grj.hellospringboot.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class UserControllerTest extends ControllerTest {

    @Test
    public void getAll() throws Exception {
        //mockMvc.perform执行一个请求，MockMvcRequestBuilders.get(“/user/1”)构造一个请求，Post请求就用.post方法
        MvcResult result = this.mvc.perform(MockMvcRequestBuilders
                .get("/user/getAll")
                //session(session)注入一个session，这样拦截器才可以通过
                .session(this.session)
        )
                //ResultActions.andExpect(MockMvcResultMatchers.status().isOk())方法看请求的状态响应码是否为200如果不是则抛异常，测试不通过
                .andExpect(MockMvcResultMatchers.status().isOk())
                //最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理
                .andReturn();

        Assert.assertThat(result.getResponse().getContentAsString(),notNullValue());
    }
}