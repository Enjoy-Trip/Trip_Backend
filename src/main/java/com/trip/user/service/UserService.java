package com.trip.user.service;

import java.sql.SQLException;

import com.trip.user.model.UserDto;

public interface UserService {
	UserDto login(UserDto user) throws SQLException;
	int signup(UserDto user) throws SQLException;
	int modify(UserDto user) throws SQLException;
	int delete(int userNo) throws SQLException;
}
