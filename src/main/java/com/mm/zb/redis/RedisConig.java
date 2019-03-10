package com.mm.zb.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Creat by ZB
 * 2019-02-23 23:19
 */
@Configuration
@EnableCaching
public class RedisConig {
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        Map<String, Long> expires = new HashMap<>();
        expires.put("12h", 3600 * 12L);
        expires.put("1h", 3600 * 1L);
        expires.put("10m", 60 * 10L);
        redisCacheManager.setExpires(expires);
        return redisCacheManager;
    }
}
