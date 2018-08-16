package com.wmp;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class WmpApiApplicationTests {
	
		@Resource
		private RedisTemplate<String, Object> redisTemplate;
		@Autowired
		private Environment env;
		@Test 
		public void testGet() {
			System.err.println(this.redisTemplate.opsForValue().get("dd ccc"));
			System.err.println(env.getProperty("spring.redis.host"));
		}
		@Test
		public void testSet() {
			this.redisTemplate.opsForValue().set("dd ccc", "ddddddddddddddddddddddddddddd");;
		}
}

