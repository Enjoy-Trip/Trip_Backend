package com.trip.user.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.trip.user.mapper.UserMapper;
import com.trip.user.model.UserDto;

@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public UserDto login(UserDto user) throws SQLException {
		return userMapper.login(user);
	}

}
