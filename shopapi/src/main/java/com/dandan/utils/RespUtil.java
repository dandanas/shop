package com.dandan.utils;

import com.dandan.constant.StatusCode;
import com.dandan.model.RespResult;

public class RespUtil {

	public static RespResult getResult(int status, String message, Object data) {
		return new RespResult(status, message, data);
	}

	/* ======== 成功 ======== */
	/**
	 * 获取成功返回对象（无消息无数据）
	 *
	 * @return RespResult
	 */
	public static RespResult successResp(){
		return getResult(StatusCode.OK.getStatus(), "", "");
	}

	/**
	 * 获取成功对象 (有消息无数据)
	 * @param message 消息
	 * @return RespResult
	 */
	public static RespResult successResp(String message){
		return getResult(StatusCode.OK.getStatus(), message, "");
	}

	/**
	 * 获取成功返回对象 (无消息有数据)
	 * @param data
	 * @return RespResult
	 */
	public static RespResult successResp(Object data){
		return getResult(StatusCode.OK.getStatus(), "", data);
	}

	/**
	 * 获取成功返回对象
	 * @param message
	 * @param data
	 * @return RespResult
	 */
	public static RespResult successResp(String message, Object data){
		return getResult(StatusCode.OK.getStatus(), message, data);
	}

	/* ======== 失败 ======== */

	/**
	 * 获取失败返回对象
	 * @param message 消息
	 * @return RespResult
	 */
	public static RespResult failResult(String message){
		return getResult(StatusCode.ERROR.getStatus(), message, "");
	}

	/**
	 * 获取失败返回对象
	 * @param StatusCode
	 * @return RespResult
	 */
	public static RespResult failResult(StatusCode statusCode){
		return getResult(statusCode.getStatus(), statusCode.getErrorCode(), "");
	}
}
