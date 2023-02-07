package com.kristofferph.security.game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kristofferph.security.mapper.GameMapper;
import com.kristofferph.security.mapper.UserMapper;
import com.kristofferph.security.user.User;
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
public class AppService {
    private final AppRepository repository;
    private final GameMapper mapper = Mappers.getMapper(GameMapper.class);

    @Autowired
    public AppService(AppRepository repository, DelegatingApplicationListener delegatingApplicationListener) {
        this.repository = repository;

    }

    @SneakyThrows
    public ResponseEntity<ArrayList<AppResponse>> getAppsFromSteam() {

        try {

            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.steampowered.com/ISteamApps/GetAppList/v2/?format=json";

            ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
            String json = result.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);

            JsonNode appsNode = root.path("applist").path("apps");
            ArrayList<App> apps = new ArrayList<>();

            for (JsonNode appNode : appsNode) {
                App app = new App();
                app.setAppid(appNode.get("appid").asInt());
                app.setName(appNode.get("name").asText());
                apps.add(app);
            }

            persistAllApps(apps);
            var response = mapper.fromRespToModel(apps);

            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void persistAllApps(ArrayList<App> apps) {

        repository.saveAll(apps);
    }

}

