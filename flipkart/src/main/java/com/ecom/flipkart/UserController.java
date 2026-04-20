package com.ecom.flipkart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private List<User> userList = new ArrayList<>();

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userList;
    }

    //Before we fetch data, we need data to be present in DB.
    //So creating POST ENDPOINT

    @PostMapping("/api/users")
    public List<User> createUsers(@RequestBody User user) {
        userList.add(user);
        return userList;
    }


}

