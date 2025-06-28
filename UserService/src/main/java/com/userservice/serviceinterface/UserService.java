package com.userservice.serviceinterface;

import com.userservice.payload.UserDto;

import java.util.List;

public interface UserService {

    //create user
    UserDto createUser(UserDto userDto);

    //get user by id
    UserDto getByUserId(Long userId);

    //get all user list
    List<UserDto> getAllUsers();

    //uprate user id id
    UserDto updateUser(Long userId,UserDto update);

    //delate user by id
    void deleteUser(Long userId);


}
