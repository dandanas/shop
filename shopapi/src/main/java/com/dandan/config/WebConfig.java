package com.dandan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private TokenInterceptor tokenInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tokenInterceptor).addPathPatterns("/**")
		.excludePathPatterns("/user/login")
		.excludePathPatterns("/user/register")
		.excludePathPatterns("/welcome");
	}

	//跨域问题
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/*").allowedOrigins("*");
	}
}
