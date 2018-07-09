package com.asisinfo.service;

import com.asisinfo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private AsyncService asyncService;

    @Test
    public void isLoginTest() {
        System.out.println(userService.isLogin("1","2"));
    }

    @Test
    public void testAsync(){
        asyncService.testAsync();
        System.out.println("test...");
    }
}
