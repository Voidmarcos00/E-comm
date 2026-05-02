package com.ecom.flipkart;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{

        private final UserRepository userRepository;
//        private List<User> userList = new ArrayList<>();
//        private Long nextid =1L;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchAllUsers(){
//            return userList;
            return userRepository.findAll();
        }

        public void addUser(User user){
//            user.setId(nextid++);
//            userList.add(user);
            userRepository.save(user);
        }

    public Optional<User> fetchById(Long id) {
//        for (User user : userList) {
//            if(user.getId().equals(id)){
//                return user;
//            }
//        }
//        return null;

        //JAVA STREAMS (Optional)
//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst();
        return userRepository.findById(id);
    }

    public Boolean updateUserById(Long id, User Updateduser) {
//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst()
//                .map(existingId -> {
//                    existingId.setName(Updateduser.getName());
//                    existingId.setAge(Updateduser.getAge());
//                    return true;
//                }).orElse(false);
        return userRepository.findById(id)
                .map(existingId -> {
                    existingId.setName(Updateduser.getName());
                    existingId.setAge(Updateduser.getAge());
                    userRepository.save(existingId);
                    return true;
                }).orElse(false);
    }
}
