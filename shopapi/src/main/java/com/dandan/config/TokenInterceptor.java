package com.dandan.config;

import com.alibaba.fastjson.JSON;
import com.dandan.utils.RespUtil;
import com.dandan.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private TokenUtil tokenUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token = request.getHeader("token");
		if(StringUtils.isEmpty(token)){
			token = request.getParameter("token");
		}
		if(StringUtils.isEmpty(token)){
			this.writeErrorMeg("token为空", response);
			return false;
		}
		Object userId = tokenUtil.getTokenValue(token);
		if(userId == null){
			this.writeErrorMeg("token已过期,请重新登录", response);
			return false;
		}
        // 重新设置过期时间
		tokenUtil.setTokenTTL(token, 1000 * 60 * 30);
		request.setAttribute("userId", userId);
		request.setAttribute("token", token);
		return true;
	}

	private void writeErrorMeg(String msg, HttpServletResponse response)throws IOException  {
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(JSON.toJSONString(RespUtil.failResult(msg)));
	}
}
