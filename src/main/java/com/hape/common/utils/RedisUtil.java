package com.hape.common.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, Long size, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, size, timeUnit);
    }

    public Boolean expired(String key, int second) {
        return stringRedisTemplate.expire(key, second, TimeUnit.SECONDS);
    }

    public boolean exists(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    public Set<String> keys(String key) {
        return stringRedisTemplate.keys(key);
    }

    /**
     * 加入缓存
     *
     * @param key 键
     * @param map 键
     * @return
     */
    public void add(String key, Map<String, Object> map) {
        stringRedisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 获取 key 下的 所有  hashkey 和 value
     *
     * @param key 键
     * @return
     */
    public Map<Object, Object> getHashEntries(String key) {
        return stringRedisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取指定key的值string
     *
     * @return
     */
    public Object getMapValue(String key, String item) {
        return stringRedisTemplate.opsForHash().get(key, item);
    }

    public boolean hasHashKey(String key, String item) {
        return stringRedisTemplate.opsForHash().hasKey(key, item);
    }
}