package com.ecom.flipkart.Mapper;

import com.ecom.flipkart.Domain.User;
import com.ecom.flipkart.Model.UserRequestDTO;
import com.ecom.flipkart.Model.UserResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2026-05-02T18:41:26+0530",
        comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setName( dto.getName() );
        user.setAge( dto.getAge() );

        return user;
    }

    @Override
    public UserResponseDto toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String name = null;
        Long id = null;

        name = user.getName();
        id = user.getId();

        UserResponseDto userResponseDto = new UserResponseDto( id, name );

        return userResponseDto;
    }
}
