package com.asisinfo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步注解测试
 */
@Service
public class AsyncService {
    @Async
    public void testAsync(){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("async...");
    }
}
