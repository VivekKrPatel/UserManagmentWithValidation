package com.example.UserManagmentSystem.controllers;

import com.example.UserManagmentSystem.models.User;
import com.example.UserManagmentSystem.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "users/all")
    public List<User>  getAllUsers(){
        return userService.fetchAllUsers();
    }

//    get user by specific userId
    @GetMapping(value = "user/byUserId/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUserByUserId(userId);
    }

    @PostMapping(value = "/user")
    public String saveUser(@Valid @RequestBody User user){
        return userService.sendUser(user);
    }

    @DeleteMapping(value = "user/byUserId/{userId}")
    public String removeUserById(@PathVariable Integer userId){
        return userService.removeUserById(userId);
    }

    @PutMapping(value = "/user/byUserId/{userId}/email/{email}")
    public String updateEmailByUserId(@PathVariable Integer userId,@PathVariable String email){
        return userService.updateEmailBasedOnUserId(userId,email);
    }

}
