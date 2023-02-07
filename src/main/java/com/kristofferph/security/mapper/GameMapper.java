package com.kristofferph.security.mapper;

import com.kristofferph.security.game.App;
import com.kristofferph.security.game.AppResponse;
import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface GameMapper {
    ArrayList<App> persistAppsToDatabase(ArrayList<AppResponse> appDest);
    ArrayList<AppResponse> fromRespToModel(ArrayList<App> appSrc);
}
