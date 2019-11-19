package cn.yupcd.web.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yupcd.web.exception.UserException;

@Controller
public class WebController {

	@Value("${aliyun.url}")
	private String url;
	
	@GetMapping("/dashboard")
	public String index() {
		System.out.println("aliyun.url=" + url);
		return "dashboard";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Map<String, Object> message) throws Exception {
		Optional.ofNullable(username).orElseThrow(() -> new UserException("username or password is error!"));
		Optional.ofNullable(password).filter(p->"123".equals(p)).orElseThrow(() -> new UserException("username or password is error!"));
		session.setAttribute("loginUser", username);
		return "redirect:/users";
	}
}
