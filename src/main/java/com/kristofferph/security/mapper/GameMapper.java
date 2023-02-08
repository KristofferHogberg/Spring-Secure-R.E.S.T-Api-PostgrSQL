package com.kristofferph.security.mapper;

import com.kristofferph.security.game.App;
import com.kristofferph.security.game.AppResponse;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {
    ArrayList<App> persistAppsToDatabase(ArrayList<AppResponse> appDest);
    ArrayList<AppResponse> fromAppResponsesToModels(ArrayList<App> appDest);
    AppResponse fromAppResponseToModel(App appDest);
}
