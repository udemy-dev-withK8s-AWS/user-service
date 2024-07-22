package com.codedecode.userinfo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codedecode.userinfo.dto.UserDto;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public UserDto addUser(UserDto userDto) {
		return UserMapper.INSTANCE.mapUserToUserDto(userRepo.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto)));
	}
	
	public List<UserDto> findAllUsers(){
		return userRepo.findAll().stream()
				.map(user -> UserMapper.INSTANCE.mapUserToUserDto(user))
				.collect(Collectors.toList());
	}
	
	public ResponseEntity<UserDto> findUserById(Integer id){
		Optional<User> restaurant = userRepo.findById(id);
		
		if(restaurant.isPresent()) {
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(userRepo.findById(id).get()),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		return UserMapper.INSTANCE.mapRestaurantToUserDto(userRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Restaurant Not Found!!")));
	}

	
}
