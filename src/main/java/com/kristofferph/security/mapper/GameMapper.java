package com.kristofferph.security.mapper;

import com.kristofferph.security.game.Game;
import com.kristofferph.security.game.GameResponse;
import org.mapstruct.Mapper;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface GameMapper {
    ArrayList<GameResponse> fromGameResponsesToModels(ArrayList<Game> gameDest);
    GameResponse fromGameResponseToModel(Game gameDest);
}
