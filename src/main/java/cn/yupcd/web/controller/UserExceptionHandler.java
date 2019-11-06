package cn.yupcd.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserException.class)
	public String handlerException(Exception e, HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "");
		map.put("message", e.getMessage());
		request.setAttribute("javax.servlet.error.status_code", 400);
		return "forward:/error";
	}
}
