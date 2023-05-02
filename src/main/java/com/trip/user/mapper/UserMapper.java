package com.trip.user.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.trip.user.model.UserDto;

@Mapper
public interface UserMapper {
	UserDto login(UserDto user) throws SQLException;
	int signup(UserDto user) throws SQLException;
	int modify(UserDto user) throws SQLException;
	int delete(int userNo) throws SQLException;
	
}
