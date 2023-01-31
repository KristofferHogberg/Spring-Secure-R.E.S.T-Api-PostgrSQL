package com.kristofferph.security.mapper;

import com.kristofferph.security.user.User;
import com.kristofferph.security.user.UserResponse;
import com.kristofferph.security.user.UserService;
import com.kristofferph.security.user.UserUpdatedResponse;
import org.hibernate.cfg.annotations.reflection.internal.XMLContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserUpdatedResponse updateToUser(User userSource);
    User userToUpdate(UserUpdatedResponse userDest);

}
