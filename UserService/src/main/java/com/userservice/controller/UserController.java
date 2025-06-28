package com.userservice.controller;


import com.userservice.payload.UserDto;
import com.userservice.serviceinterface.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    //Create user
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }

    //get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getByUserId(userId));
    }

    //Get All User list
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUserList() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    //update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto update) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userId,update));
    }

    //Delete user by id
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delateUserById(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("User delete successfully!");
    }

}
