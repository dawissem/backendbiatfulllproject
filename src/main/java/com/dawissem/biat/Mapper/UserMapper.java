package com.dawissem.biat.Mapper;

import com.dawissem.biat.Dto.UserDto;
import com.dawissem.biat.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto );
}
