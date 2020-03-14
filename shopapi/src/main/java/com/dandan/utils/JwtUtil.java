package com.dandan.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class JwtUtil {

	private static String headerKey = "token";

	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	private static final String SIGN_PRIVATE_KEY = "Authorization";

	private static final long EXPIRATION_TIME = 1000 * 60 * 30;

	/**
	 * 根据身份id获取token
	 * @param userId
	 * @return
	 */
	public static String createToken (Integer userId){
		Date now = new Date();
		return Jwts.builder()
				.setHeaderParam("typ","JWT")
				.setSubject(userId.toString())
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SIGN_PRIVATE_KEY)
				.compact();
	}

	/**
	 * 获取token中的信息
	 * @param token
	 * @return
	 */
	public static Claims getTokenClaim(String token){
		try{
			return Jwts.parser().setSigningKey(SIGN_PRIVATE_KEY).parseClaimsJws(token).getBody();
		}catch (Exception e){
			logger.error("[getTokenClaim][exception] getTokenClaim exception {} ",e.getMessage());
			return null;
		}
	}

	/**
	 * Token是否过期
	 * @param expirationTime
	 * @return
	 */
	public static boolean isTokenExpired(Date expirationTime){
		return expirationTime.before(new Date());
	}

	public static String getHeaderKey(){
		return headerKey;
	}
}
