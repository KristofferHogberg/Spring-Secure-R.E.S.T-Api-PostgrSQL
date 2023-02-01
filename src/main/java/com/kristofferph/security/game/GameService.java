package com.kristofferph.security.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameService {
    private final GameRepository repository;

    @Autowired
    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<String> getAllApps() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.steampowered.com/ISteamApps/GetAppList/v2/?format=json";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println(response.getBody());

        return response;

    }


}
