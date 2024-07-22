package com.codedecode.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.userinfo.dto.UserDto;
import com.codedecode.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/fetchAllUsers")
	public ResponseEntity<List<UserDto>> fetchAllUsers() {
		
		return new ResponseEntity<List<UserDto>>(userService.findAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
		
		return new ResponseEntity<UserDto>(userService.addUser(userDto), HttpStatus.CREATED);
	}
	

	@GetMapping("/fetchUserById/{id}")
	public ResponseEntity<UserDto> fetchUserById(@PathVariable Integer id) {
		
		return userService.findUserById(id);
	}
	

}
