package com.wdk.permissions.web.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created by wdk on 2019/12/13
 */
public class UserContext {

	private static ThreadLocal<UserContext> threadLocal = ThreadLocal.withInitial(() -> new UserContext());


	private String lastPages;

	private String remortIP;


	private String traceId;

	private long startTime;

	private boolean creator;

	private HttpServletRequest request;

	private HttpServletResponse response;

	public String getLastPages() {
		return lastPages;
	}

	public void setLastPages(String lastPages) {
		this.lastPages = lastPages;
	}

	public static void release() {
		threadLocal.remove();
	}

	public static UserContext current() {
		return threadLocal.get();
	}

	public String getRemortIP() {
		return remortIP;
	}

	public void setRemortIP(String remortIP) {
		this.remortIP = remortIP;
	}

	public static ThreadLocal<UserContext> getThreadLocal() {
		return threadLocal;
	}

	public static void setThreadLocal(ThreadLocal<UserContext> threadLocal) {
		UserContext.threadLocal = threadLocal;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public boolean isCreator() {
		return creator;
	}

	public void setCreator(boolean creator) {
		this.creator = creator;
	}
}
