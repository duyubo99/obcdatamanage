package com.asisinfo.other;

import com.asisinfo.config.MyRedisConfig;
import com.asisinfo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OtherTests {
    //操作k-v都是字符串的
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //k-v都是对象的
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    RedisTemplate<Object,User> userRedisTemplate;

    @Test
    public void testRedis(){
        User u = new User();
        u.setId(1);
        u.setPassword("123");
        u.setUsername("zhangsan");
        userRedisTemplate.opsForValue().set("userttt",u);
    }
}
