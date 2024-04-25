package com.home.wupupupu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class WupupupuApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void testRedis(){
        ValueOperations<String,String> operations=redisTemplate.opsForValue();
        operations.set("test","你好 redis 15s",15, TimeUnit.SECONDS);
    }

}
