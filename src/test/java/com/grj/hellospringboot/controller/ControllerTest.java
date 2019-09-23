package com.grj.hellospringboot.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * @Description 使用MockMvc实现了对Http请求的模拟，能够不启动工程就能测试Controller接口
 * @Author guorenjie
 * @Date 2019/9/18 23:42
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    WebApplicationContext wac;
    MockMvc mvc;
    MockHttpSession session;

    @Before
    public void setupMockMvc(){
        System.out.println("测试开始");
        //初始化MockMvc对象
        mvc = MockMvcBuilders.webAppContextSetup(wac)
                //默认每次执行请求后都做的动作
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
        session = new MockHttpSession();
        //拦截器那边会判断是否登录，所以这里我注入了一个用户，你也可以直接修改拦截器取消验证用户登录，先测试完再开启
        //session.setAttribute("user",user);
    }
    @After
    public void after(){
        System.out.println("测试结束");
    }

    /**
     * 测试用例
     * @throws Exception
     */
    @Test
    public void peform() throws Exception {
        //mockMvc.perform执行一个请求，MockMvcRequestBuilders.get(“/user/1”)构造一个请求，Post请求就用.post方法
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/user/getUserById?id={id}","1")
                //.get("/user/getUserById")
                //.param("id", "1")
                //contentType(MediaType.APPLICATION_JSON_UTF8)代表发送端发送的数据格式
                //.contentType(MediaType.APPLICATION_JSON_UTF8)
                //accept(MediaType.APPLICATION_JSON_UTF8)代表客户端希望接受的数据类型
                //.accept(MediaType.APPLICATION_JSON_UTF8)
                //传json参数
                //.content(json.getBytes())
                //session(session)注入一个session，这样拦截器才可以通过
                .session(session)
        )
                //ResultActions.andExpect添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确
                //ResultActions.andExpect(MockMvcResultMatchers.status().isOk())方法看请求的状态响应码是否为200如果不是则抛异常，测试不通过
                .andExpect(MockMvcResultMatchers.status().isOk())
                //andExpect(MockMvcResultMatchers.jsonPath(“$.author”).value(“嘟嘟MD独立博客”))这里jsonPath用来获取author字段比对是否为嘟嘟MD独立博客,不是就测试不通过
                //.andExpect(MockMvcResultMatchers.jsonPath("$.author").value("嘟嘟MD独立博客"))
                //最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理
                .andReturn();

        //Assert.assertThat(result.getResponse().getContentAsString(),notNullValue());
    }

}
