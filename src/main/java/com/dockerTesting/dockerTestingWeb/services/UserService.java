package com.dockerTesting.dockerTestingWeb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dockerTesting.dockerTestingWeb.entity.User;
import com.dockerTesting.dockerTestingWeb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public String addUser(User user) {

		userRepository.save(user);

		return "User Added Successfully";
	}

	public User getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
	}

}
