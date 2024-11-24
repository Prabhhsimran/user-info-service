package com.mealmap.userinfo.service;

import com.mealmap.userinfo.dto.UserDTO;
import com.mealmap.userinfo.entity.User;
import com.mealmap.userinfo.mapper.UserMapper;
import com.mealmap.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User user = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(user);
    }

    public ResponseEntity<UserDTO> fetchUserById(Integer userId) {
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent())
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
