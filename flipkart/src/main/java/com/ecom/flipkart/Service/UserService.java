package com.ecom.flipkart.Service;

import com.ecom.flipkart.Repositories.UserRepository;
import com.ecom.flipkart.Domain.User;
import com.ecom.flipkart.Mapper.UserMapper;
import com.ecom.flipkart.Model.UserRequestDTO;
import com.ecom.flipkart.Model.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService{

        private final UserRepository userRepository;
//        private List<User> userList = new ArrayList<>();
//        private Long nextid =1L;

       private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDto> fetchAllUsers(){
//            return userList;
            return userRepository.findAll().stream()
                    .map(userMapper::toResponse)
                    .collect(Collectors.toList());
        }

        public void addUser(UserRequestDTO dto){
//            user.setId(nextid++);
//            userList.add(user);
            User user =userMapper.toEntity(dto);
            userRepository.save(user);
        }

    public Optional<UserResponseDto> fetchById(Long id) {
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
        return userRepository.findById(id).map(userMapper::toResponse);
    }

    public Boolean updateUserById(Long id, UserRequestDTO dto) {
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
                    existingId.setName(dto.getName());
                    existingId.setAge(dto.getAge());
                    userRepository.save(existingId);
                    return true;
                }).orElse(false);
    }
}
