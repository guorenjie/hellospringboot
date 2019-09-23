package com.grj.hellospringboot;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author guorenjie
 * @Date 2019/9/18 23:42
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Before
    public void setupMockMvc(){ System.out.println("测试开始"); }
    @After
    public void after(){
        System.out.println("测试结束");
    }
}
