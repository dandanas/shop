package com.dandan.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WebLogAspect {
	private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	/** 以 controller 包下定义的所有请求为切入点 */
	@Pointcut("execution(public * com.dandan.controller..*.*(..))")
	public void weblog(){}

	/**
	 * 在织点之前切入
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("weblog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		//开始打印请求日志
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 打印请求相关参数
		logger.info("========================================== Start ==========================================");
		// 打印请求 url
		logger.info("URL            : {}", request.getRequestURL().toString());
		// 打印 Http method
		logger.info("HTTP Method    : {}", request.getMethod());
		// 打印调用 controller 的全路径以及执行方法
		logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
		// 打印请求入参
//		logger.info("Request Args   : {}", JSON.toJSONString(joinPoint.getArgs()));
	}

	/**
	 * 在切点之后织入
	 * @throws Throwable
	 */
	@After("weblog()")
	public void doAfter() throws Throwable {
		logger.info("=========================================== End ===========================================");
	}

	/**
	 * 环绕
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("weblog())")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		// 打印出参
		logger.info("Response Args  : {}", JSON.toJSONString(result));
		// 执行耗时
		logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
		return result;
	}
}
