package com.app.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice(basePackages="com.app.controller")
public class GlobalExceHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String,Object> errorJSon(){
		Map<String,Object> error=new HashMap<String,Object>();
		error.put("errorCode", "500");
		error.put("errorMsg", "系统异常");
		return error;
	}
}
