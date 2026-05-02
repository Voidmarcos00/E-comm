package com.ecom.flipkart;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO dto);

    @Mapping(target = "name", source = "name")
    UserResponseDto toResponse(User user);
}