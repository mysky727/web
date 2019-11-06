package cn.yupcd.web.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@GetMapping("/dashboard")
	public String index() {
		return "dashboard";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Map<String, Object> message) throws Exception {
		Optional.ofNullable(username).orElseThrow(() -> new Exception("username or password is error!"));
		Optional.ofNullable(password).filter(p->"123".equals(p)).orElseThrow(() -> new Exception("username or password is error!"));
		session.setAttribute("loginUser", username);
		return "redirect:/users";
	}
}
