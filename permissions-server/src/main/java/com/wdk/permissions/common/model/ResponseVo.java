package com.wdk.permissions.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wdk.permissions.common.enums.*;

import java.io.Serializable;

/**
 * Created by wdke on 1541852927067.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo<T> implements Serializable {



	private static final long serialVersionUID = 3073226328007685525L;
	
	private int code;

	private String msg;

	private T data;


	public ResponseVo() {
	  
	}

	public ResponseVo(ResponseStatusEnum status) {
		this.code = status.getCode();
		this.msg = status.getMsg();
	}


	public ResponseVo(ResponseStatusEnum status, T data) {

		this.code = status.getCode();
		this.msg = status.getMsg();
		this.data = data;
	}
	
	public ResponseVo(int status, String message) {
		this.code = status;
		this.msg = message;
	}

	public ResponseVo(int status, String message, T data) {
		this.code = status;
		this.msg = message;
		this.data = data;
	}


	public ResponseVo(ReturnStatusEnum returnStatus, T data) {
		this.code = returnStatus.getValue();
		this.msg = returnStatus.getDesc();
		this.data = data;
	}

	public ResponseVo(ReturnStatusEnum returnStatus) {
		this.code = returnStatus.getValue();
		this.msg = returnStatus.getDesc();
	}

	public int getCode() {
		return code;
	}

	public void setStatus(int status) {
		this.code = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String message) {
		this.msg = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	@JsonIgnore
	public boolean isSuccess() {
		return getCode() == 200;
	}
}
