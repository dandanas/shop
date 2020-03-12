package com.dandan.constant;

public enum StatusCode {

	OK(0, "成功"),
	ERROR(1, "失败");

	private int status;
	private String errorMessage;

	private StatusCode(int status, String errorMessage){
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public int getStatus(){
		return status;
	}

	public String getErrorCode(){
		return errorMessage;
	}
}
