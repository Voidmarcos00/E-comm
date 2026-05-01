package com.ecom.flipkart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getAllUsers() {
    //        return userList;
        return ResponseEntity.ok(userService.fetchAllUsers());
        //ALTERNATIVE RESPONSE :
    //  return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.fetchById(id);
//        if(user == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(user);
//        return ResponseEntity.ok(userService.fetchById(id));

        // JAVA STREAMS FOR DATA PROCESSING
        return userService.fetchById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    //Before we fetch data, we need data to be present in DB.
    //So creating POST ENDPOINT

    @PostMapping("/api/users")
//    public List<User> createUsers(@RequestBody User user) {
//        userList.add(user);
//        return userList;

        public  ResponseEntity<String> createUsers(@RequestBody User user) {
            userService.addUser(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    //PUT ENDPOINT
    @PutMapping("api/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Boolean updated = userService.updateUserById(id,updatedUser);
        if(updated)
            return ResponseEntity.ok("User updated");
        return ResponseEntity.notFound().build();
    }
}

