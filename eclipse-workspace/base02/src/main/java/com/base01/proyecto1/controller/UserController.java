package com.base01.proyecto1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base01.proyecto1.entity.User;
import com.base01.proyecto1.service.UserService;
@CrossOrigin("origins= http://localhost:8080")
@RestController
@RequestMapping("/api/signup")
public class UserController {
		@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<?> create (@RequestBody User user ){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable (value ="id") Long userId){
		Optional<User> oUser = userService.findById(userId);
		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.ok(oUser);
	}

}
