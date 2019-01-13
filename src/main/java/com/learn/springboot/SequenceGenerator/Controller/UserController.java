package com.learn.springboot.SequenceGenerator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.SequenceGenerator.Service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public void save() {
		System.out.println("Inside UserController");
		userService.saveUser();
	}
	
}
