package com.ecom.flipkart;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{
        private List<User> userList = new ArrayList<>();
        private Long nextid =1L;

        public List<User> fetchAllUsers(){
            return userList;
        }

        public void addUser(User user){
            user.setId(nextid++);
            userList.add(user);
        }

    public Optional<User> fetchById(Long id) {
//        for (User user : userList) {
//            if(user.getId().equals(id)){
//                return user;
//            }
//        }
//        return null;

        //JAVA STREAMS (Optional)
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
