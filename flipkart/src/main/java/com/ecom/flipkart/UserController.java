package com.ecom.flipkart;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    //    private List<User> userList = new ArrayList<>();

    // Calling Service( @Autowired/ Constructor /@RequiredArgsConstructor)
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
//        return userList;
        return userService.fetchAllUsers();
    }

    //GET BY ID
    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.fetchById(id);
    }

    //Before we fetch data, we need data to be present in DB.
    //So creating POST ENDPOINT

    @PostMapping("/api/users")
//    public List<User> createUsers(@RequestBody User user) {
//        userList.add(user);
//        return userList;

        public String createUsers(@RequestBody User user) {
        userService.addUser(user);
        return "User Added Successfully";
    }

}

