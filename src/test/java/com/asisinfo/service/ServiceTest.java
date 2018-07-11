package com.asisinfo.service;

import com.asisinfo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private AsyncService asyncService;

    /**
     * 测试异步
     */
    @Test
    public void isLoginTest() {
        System.out.println(userService.isLogin("1","2"));
    }

    /**
     * 测试异步
     */
    @Test
    public void testAsync(){
        asyncService.testAsync();
        System.out.println("test...");
    }

    /**
     * 测试分页
     */
    @Test
    public void testPage(){
//        userService.findAll();
    }
}
