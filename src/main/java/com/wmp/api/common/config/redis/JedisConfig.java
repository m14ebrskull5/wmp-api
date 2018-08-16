package com.wmp.api.common.config.redis;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @ClassName: JedisConfig
 * @Description: TODO(配置针对User的RedisTemplate实例)
 * @author chenaonan
 * @date 2018年8月16日 下午2:27:25
 */
@Configuration
public class JedisConfig extends CachingConfigurerSupport {

	private Logger logger = LoggerFactory.getLogger(JedisConfig.class);

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.pool.max-active}")
	private int maxActive;

	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;

	@Value("${spring.redis.pool.max-idle}")
	private int minIdle;

	@Value("${spring.redis.pool.max-wait}")
	private long maxWaitMillis;

	@Bean
	public ShardedJedisPool redisPoolFactory() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setMaxTotal(maxActive);
		jedisPoolConfig.setMinIdle(minIdle);
		ArrayList<JedisShardInfo> arrayList = new ArrayList<JedisShardInfo>();
		arrayList.add(new JedisShardInfo(host, port));
		logger.info("JedisPool注入成功！");
		logger.info("redis地址：" + host + ":" + port);
		return new ShardedJedisPool(jedisPoolConfig, arrayList);
	}

}