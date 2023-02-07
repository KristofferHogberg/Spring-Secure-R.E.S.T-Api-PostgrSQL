package com.kristofferph.security.game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
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

    @Autowired
    public AppService(AppRepository repository, DelegatingApplicationListener delegatingApplicationListener) {
        this.repository = repository;

    }

    @SneakyThrows
    public ResponseEntity<String> getAllApps() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.steampowered.com/ISteamApps/GetAppList/v2/?format=json";

        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        String json = result.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(json);

        JsonNode appsNode = root.path("applist").path("apps");
        List<App> apps = new ArrayList<>();

        for (JsonNode appNode : appsNode) {
            App app = new App();
            app.setAppid(appNode.get("appid").asInt());
            app.setName(appNode.get("name").asText());
            apps.add(app);
        }

        for (App app : apps) {

            System.out.println("appid: " + app.getAppid());
            System.out.println("name: " + app.getName());
        }

        return result;

    }


}

