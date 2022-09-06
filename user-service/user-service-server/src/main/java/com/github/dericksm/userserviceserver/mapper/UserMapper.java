package com.github.dericksm.userserviceserver.mapper;

import com.github.dericksm.userservicedto.UserDTO;
import com.github.dericksm.userservicedto.request.UserRequest;
import com.github.dericksm.userservicedto.request.UserUpdateRequest;
import com.github.dericksm.userserviceserver.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    User toUser(UserRequest request);
    User toUser(UserUpdateRequest request);
}
