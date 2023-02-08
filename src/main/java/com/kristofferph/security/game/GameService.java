package com.kristofferph.security.game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kristofferph.security.mapper.GameMapper;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.context.DelegatingApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private final GameRepository repository;
    private final GameMapper mapper = Mappers.getMapper(GameMapper.class);

    @Autowired
    public GameService(GameRepository repository, DelegatingApplicationListener delegatingApplicationListener) {
        this.repository = repository;

    }

    @SneakyThrows
    public ResponseEntity<ArrayList<GameResponse>> getAppsFromSteam() {

        try {

            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.steampowered.com/ISteamApps/GetAppList/v2/?format=json";

            ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
            String json = result.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);

            JsonNode appsNode = root.path("applist").path("apps");
            ArrayList<Game> games = new ArrayList<>();

            for (JsonNode appNode : appsNode) {
                Game game = new Game();
                game.setAppid(appNode.get("appid").asInt());
                game.setName(appNode.get("name").asText());
                games.add(game);
            }

            persistAllApps(games);
            var response = mapper.fromGameResponsesToModels(games);

            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void persistAllApps(ArrayList<Game> games) {
        try {
            repository.saveAll(games);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public List<GameResponse> getAllAppsFromDb() {

        var apps = repository.findAll();

        List<GameResponse> gameRespons = new ArrayList<>();
        apps.forEach(game -> {
            gameRespons.add(mapper.fromGameResponseToModel(game));
        });

        return gameRespons;
    }

}

