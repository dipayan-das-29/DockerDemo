package com.example.dockerDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.dockerDemo.domain.User;
import com.example.dockerDemo.repository.UserRepository;

@Service
@Profile("dev")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User createUser(User userDet) {
		// TODO Auto-generated method stub
		return userRepository.save(userDet);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	

}
