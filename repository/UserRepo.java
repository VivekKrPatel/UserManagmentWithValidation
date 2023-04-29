package com.example.UserManagmentSystem.repository;

import com.example.UserManagmentSystem.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    private List<User> userList;

    public UserRepo(){
        userList = new ArrayList<>();
        userList.add(new User(1,"vivek","2002-01-01","vivekkrpatel2442@gmail.com","7701852442","28-04-2023","19:50"));
    }


    public List<User> fetchAllUsers() {
        return userList;
    }

    public boolean save(User user) {
        userList.add(user);
        return true;
    }

    public boolean remove(User user) {
        userList.remove(user);
        return true;
    }
}
