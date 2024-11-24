package com.mealmap.userinfo.controller;

import com.mealmap.userinfo.dto.UserDTO;
import com.mealmap.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO addedUser = userService.addUser(userDTO);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @GetMapping("/fetchUser/{userId}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable Integer userId){
        return userService.fetchUserById(userId);
    }
}
