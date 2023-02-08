package com.kristofferph.security.mapper;

import com.kristofferph.security.user.User;
import com.kristofferph.security.user.UserResponse;
import com.kristofferph.security.user.UserUpdatedResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserUpdatedResponse updateToUser(User userSrc);
    UserResponse getUser(User userSrc);
    User userToUpdate(UserUpdatedResponse userDest);
    UserResponse getAllUsers(User userSrc);


}
