package com.wdk.permissions.web.interceptor;

import com.alibaba.druid.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wdk on 2018/6/20.
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {


	private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		/* 解决跨域请求问题 */
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods", "HEAD,POST,GET,PUT,DELETE,OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,Cache-Control,Pragma,Content-Type");

		UserContext.current().setRequest(request);
		UserContext.current().setResponse(response);
		String traceId = request.getSession().getId();

		UserContext.current().setTraceId(traceId);
		long start = System.currentTimeMillis();
		UserContext.current().setStartTime(start);

		String requestURI = request.getRequestURI();
		logger.info("requestURI->{}", requestURI);

		if (requestURI.startsWith("/permissions-server/api")
				||requestURI.startsWith("/permissions-server/login")
				||requestURI.startsWith("/permissions-server/toLogin")) {
			return true;
		} else {
			return preHandleService(request, response);
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long start = UserContext.current().getStartTime();
		long duration = System.currentTimeMillis() - start;
		if (duration > 3000) {
			logger.info("超时报警短信【__trace_id：{}】【duration：{}】", UserContext.current().getTraceId(), duration);
		}
		UserContext.release();
	}

	private boolean preHandleService(HttpServletRequest request, HttpServletResponse response) {


		return true;
	}

}
