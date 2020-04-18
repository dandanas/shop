package com.dandan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class TokenUtil {

	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 创建token
	 * @param userId
	 * @param username
	 * @return
	 */
	public String createToken(Integer userId, String username){
		StringBuilder token = new StringBuilder();
		//加token
		token.append("token:");
		//加加密用户名与ID
		token.append(DigestUtils.md5Digest((userId + username).getBytes())+"-");
		//加时间
		token.append(new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date())+ "-");
		//加6位随机数
		token.append(new Random().nextInt((999999 - 111111 + 1)) + 111111);
		this.saveToken(token.toString(), userId, 1000 * 60 * 30);
		return token.toString();
	}

	/**
	 * token持久化
	 * @param userId
	 * @param token
	 * @param time
	 */
	public void saveToken(String token, Integer userId, long time){
		redisUtil.set(token, userId.toString(), time);
	}

	public Object getTokenValue(String token){
		return token == null ? null : redisUtil.get(token);
	}

	public void setTokenTTL(String token, long time){
		redisUtil.expire(token, time);
	}

	public void delToken(String token){
		redisUtil.del(token);
	}
}
