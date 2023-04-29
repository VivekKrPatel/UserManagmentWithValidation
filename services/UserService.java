package com.example.UserManagmentSystem.services;

import com.example.UserManagmentSystem.models.User;
import com.example.UserManagmentSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> fetchAllUsers() {
        return userRepo.fetchAllUsers();
    }

    public User getUserByUserId(String userId) {
        Integer userIdInt = Integer.parseInt(userId);
        List<User> userList = fetchAllUsers();
        for(User user:userList){
            if(user.getUserId() == userIdInt){
                return user;
            }
        }

        return new User();
    }

    public String sendUser(User user) {
        boolean isInserted = userRepo.save(user);
        if(user != null){
            if (isInserted) {
                return "Saved Successfully ...!!";
            }
            return "Failed to save user..!!!";
        }else{
            return "user cannot be null...";
        }
    }

    public String removeUserById(Integer userId) {

        List<User> userList = fetchAllUsers();

        for(User user:userList){
            if(user.getUserId() == userId){
                boolean isRemoved = userRepo.remove(user);
                if(isRemoved){
                    return "Removed Successfully...!!!!";
                }else {
                    return "Remove Unsuccessful ...internal server error";
                }
            }
        }
        return "userId : "+userId +" does not present in database";
    }

    public String updateEmailBasedOnUserId(Integer userId, String email) {

        List<User> userList = fetchAllUsers();
        for(User user:userList){
            if(user.getUserId() == userId){
                boolean isRemoved = userRepo.remove(user);//true
                if(isRemoved){ //true
                    user.setEmail(email);
                    boolean isInserted = userRepo.save(user);
                    if(isInserted){
                        return "Updated email with UserId : "+userId+" successfully..!!";
                    }else{
                        return "Failed to update..!!!";
                    }
                }else{
                    return "Remove Unsuccessful ...internal server error";
                }
            }
        }
        return "UserId : "+userId+" does not exist in database";
    }
}
