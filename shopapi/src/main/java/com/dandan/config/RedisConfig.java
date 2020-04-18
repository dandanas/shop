package com.dandan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String,Object>template=new RedisTemplate<>();
		RedisSerializer redisSerializer = new StringRedisSerializer();
		//关联
		template.setConnectionFactory(factory);
		//设置key的序列化器
		template.setKeySerializer(redisSerializer);
		//设置value的序列化器
		template.setValueSerializer(redisSerializer);
		return template;
	}

}
