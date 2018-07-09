package com.asisinfo.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class MyCacheConfig {
//    /**
//     * 定义生成key的方式
//     * 需要如下指定：
//     * @Cacheable(value = "user",keyGenerator = "myKeyGenerator")
//     * CacheAspectSupport   findCachedItem  中可以看到缓存key
//     *
//     * @CachePut(value = "user",key = "#user.id")指定时注意：key要与Cacheable保持一致
//     *
//     * @CacheEvict(value = "user") 指定时注意：key要与Cacheable保持一致
//     *
//     * @CacheConfig(cacheNames = "user")
//     * @Service
//     * public class UserService {  类的注解
//     */
//    @Bean("myKeyGenerator")
//    public KeyGenerator keyGenerator(){
//        return new KeyGenerator(){
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                return method.getName()+"["+ Arrays.asList(params).toString()+"]";
//            }
//        };
//    }
}
