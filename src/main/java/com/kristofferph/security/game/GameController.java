package com.kristofferph.security.game;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/loadapps")
    public ResponseEntity<ArrayList<GameResponse>> getAppsFromSteam() {

        return gameService.getAppsFromSteam();
    }

    @GetMapping("/listall")
    public ResponseEntity<List<GameResponse>> getAllSteamApps() {

        var apps = gameService.getAllAppsFromDb();
        return ResponseEntity.ok().body(apps);
    }

}
