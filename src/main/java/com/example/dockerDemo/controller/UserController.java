package com.example.dockerDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dockerDemo.domain.User;
import com.example.dockerDemo.service.UserService;

@RestController
@RequestMapping(value="/user/v1",produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User userDet)
	{
		return userService.createUser(userDet);	
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
		
	}
}
