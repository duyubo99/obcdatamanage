package com.asisinfo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
/**
 * 基于注解的缓存配置
 * @Cacheable   增
 * @CachePut(key = "#user.id")      改
 * @CacheEvict      删
 */
@EnableCaching
/**
 * 基于注解的rabbit
 * @RabbitListener+@EnableRabbit监听消息队列里的内容
 */
@EnableRabbit
public class ObcdatamanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObcdatamanageApplication.class, args);
    }
}
