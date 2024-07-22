package com.codedecode.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.userinfo.dto.UserDto;
import com.codedecode.userinfo.entity.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User mapUserDtoToUser(UserDto userDto);
	
	UserDto mapUserToUserDto(User user);
	
	
}
