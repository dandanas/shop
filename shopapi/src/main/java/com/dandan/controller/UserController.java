package com.dandan.controller;

import com.dandan.model.RespResult;
import com.dandan.pojo.User;
import com.dandan.service.UserService;
import com.dandan.utils.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public RespResult login(User user){
		try{
			return userService.login(user);
		}catch (Exception e){
			logger.error("[login][exception] login exception : {}", e.getMessage());
		}
		return RespUtil.failResult("登录失败");
	}

	@PostMapping("/register")
	public RespResult register(User user){
		try{
			return userService.register(user);
		}catch (Exception e){
			logger.error("[register][exception] login exception : {}", e.getMessage());
		}
		return RespUtil.failResult("注册失败");
	}
}
