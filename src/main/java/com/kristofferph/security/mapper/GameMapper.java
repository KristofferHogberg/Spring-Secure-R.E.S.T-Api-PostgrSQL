package com.kristofferph.security.mapper;

import com.kristofferph.security.game.AppResponse;
import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;

@Mapper(componentModel = "spring")
public interface GameMapper {
    AppResponse getAllApps(ResponseEntity<Object> appSrc);
}
