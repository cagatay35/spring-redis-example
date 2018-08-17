package com.ttech.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class RedisCoreService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String getStringVal(String key) {
        Object value = getValue(key);
        return value != null ? String.valueOf(value) : null;
    }

    public Object getValue(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setValue(final String key, final String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setValueWithExpire(final String key, final String value, final Long expireMin) {
        redisTemplate.opsForValue().set(key, value);
        // set a expire for a message
        redisTemplate.expire(key, expireMin, TimeUnit.MINUTES);
    }

}
