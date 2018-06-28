package com.asisinfo.config;

import com.asisinfo.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;


/**
 * redis配置
 */
@Configuration
public class MyRedisConfig {
    /**
     * 自定义序列化方式(必须指定类型，否则无法反序列化)
     * 实体类必须有无参构造器和实现Serializable接口
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object,User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, User> template = new RedisTemplate<Object, User>();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer<User> redisSerializer = new Jackson2JsonRedisSerializer<>(User.class);
        template.setDefaultSerializer(redisSerializer);
        return template;
    }
    /**
     * 一个实体类一个cacheManager
     */
    @Bean
    public RedisCacheManager userCacheManager(RedisTemplate<Object, User> userRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(userRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
