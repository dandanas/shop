package com.dandan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 根据key获取值
	 * @param key
	 * @return
	 */
	public Object get(String key){
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 将值放入缓存
	 * @param key
	 * @param value
	 */
	public void set(String key, String value){
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 将值放入缓存并设置时间
	 * @param key
	 * @param value
	 * @param time -1为无期限
	 */
	public void set(String key, String value, long time){
		if(time > 0){
			redisTemplate.opsForValue().set(key, value, time, TimeUnit.MILLISECONDS);
		}else{
			redisTemplate.opsForValue().set(key, value);
		}
	}

	/**
	 * 删除指定键
	 * @param key
	 */
	public void del(String key){
		redisTemplate.delete(key);
	}

	/**
	 * 给指定的key附加过期时间
	 * @param key
	 * @param time
	 * @return
	 */
	public boolean expire(String key, long time){
		return redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
	}

}
