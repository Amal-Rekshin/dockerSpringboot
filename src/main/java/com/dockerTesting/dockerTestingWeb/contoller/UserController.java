package com.dockerTesting.dockerTestingWeb.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dockerTesting.dockerTestingWeb.entity.User;
import com.dockerTesting.dockerTestingWeb.services.UserService;

@RestController
@RequestMapping("/student")
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping
	public ResponseEntity<String> addUserDetail(@RequestBody User user) {
		String result = userService.addUser(user);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserData(@PathVariable Long id) {
		User userResult = userService.getUser(id);
		return new ResponseEntity<User>(userResult, HttpStatus.OK);
	}
}
