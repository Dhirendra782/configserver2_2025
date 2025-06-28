package com.userservice.service.impl;

import com.userservice.exception.ResourceNotFoundException;
import com.userservice.model.User;
import com.userservice.payload.UserDto;
import com.userservice.repository.UserRepository;
import com.userservice.serviceinterface.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    private ModelMapper modelMapper;


    //Create user
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User saveUser = userRepository.save(user);
        return modelMapper.map(saveUser, UserDto.class);
    }

    //get user by id
    @Override
    public UserDto getByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        return modelMapper.map(user,UserDto.class);
    }

    //get all user list
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user-> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    //update user by id
    @Override
    public UserDto updateUser(Long userId, UserDto update) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        user.setName(update.getName());
        user.setEmail(update.getEmail());
        user.setAbout(update.getAbout());

        User updateUser = userRepository.save(user);
        return modelMapper.map(updateUser,UserDto.class);
    }

    //delete by user id
    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        userRepository.deleteById(userId);
    }

}
