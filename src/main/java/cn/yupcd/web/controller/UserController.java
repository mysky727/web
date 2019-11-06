package cn.yupcd.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import cn.yupcd.web.entities.User;
import cn.yupcd.web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public String add(User user) {
		System.out.println("add" + user);
		userService.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/user/{id}")
	public String get(@PathVariable("id") long id, Model model) {
		Optional<User> user = userService.findById(id);
		if (user.isPresent()) {
			model.addAttribute("user", user.get());
		}
		return "user-curd";
	}
	
	@GetMapping("/users")
	public String getAll(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user-curd";
	}
	
	@PutMapping("/user")
	public String update(User user) {
		System.out.println("update" + user);
		userService.update(user);
		return "redirect:/users";
	}
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable("id") long id) {
		userService.delete(id);
		return "redirect:/users";
	}
}
