package com.ecom.flipkart.Mapper;

import com.ecom.flipkart.Domain.User;
import com.ecom.flipkart.Model.UserRequestDTO;
import com.ecom.flipkart.Model.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO dto);

    @Mapping(target = "name", source = "name")
    UserResponseDto toResponse(User user);
}