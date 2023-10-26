package com.example.mywildberries.controller;


import com.example.mywildberries.dto.request.LoginRequest;
import com.example.mywildberries.dto.response.UserResponse;
import com.example.mywildberries.service.UserService;
import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;
    ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService,ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> getClient(@RequestBody @Value LoginRequest request) {

        return new ResponseEntity<>(modelMapper.map(userService.findByNameAndPassword(request.), UserResponse.class), HttpStatus.OK);
    }


}