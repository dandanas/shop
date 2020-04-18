package com.dandan.service;

import com.dandan.mapper.UserMapper;
import com.dandan.model.RespResult;
import com.dandan.pojo.User;
import com.dandan.utils.RespUtil;
import com.dandan.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserMapper userMapper;

	@Autowired
	private TokenUtil tokenUtil;

	public RespResult login(User user){
		try{
			Integer userId = userMapper.getUserByUsername(user.getUsername());
			if(userId == null){
				return RespUtil.failResult("该用户不存在");
			}
			User userData = userMapper.getUserByUserId(userId);
			if(!userData.getPassword().equals(user.getPassword())){
				return RespUtil.failResult("用户名或者密码错误");
			}
			String token = tokenUtil.createToken(userId, userData.getUsername());
			logger.info("userId : " + userId + " has take a token : " + token);
			return RespUtil.successResp(token);
		}catch (Exception e){
			logger.error("[login][exception]: {}",e.getMessage());
		}
		return RespUtil.failResult("登录失败");
	}

	public RespResult register(User user){
		try{
			int userId = userMapper.getUserByUsername(user.getUsername());
			if(userId != 0){
				return RespUtil.failResult("用户名已存在");
			}
			Integer register = userMapper.insertUser(user);
			if(register != null){
				return RespUtil.successResp("注册成功",user);
			}
		}catch (Exception e){
			logger.error("[register][exception]: {}",e.getMessage());
		}
		return RespUtil.failResult("注册失败");
	}

	public RespResult logout(String token, Integer userId){
		try{
			logger.info("userId: " + userId + " token has been deleted  token:" + token);
			tokenUtil.delToken(token);
		}catch (Exception e){
			logger.error("[logout][exception]: {}",e.getMessage());
		}
		return RespUtil.successResp();
	}
}
