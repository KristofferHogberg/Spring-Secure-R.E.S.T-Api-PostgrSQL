package com.kristofferph.security.game;

import com.kristofferph.security.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/loadapps")
    public ResponseEntity<ArrayList<GameResponse>> getAppsFromSteam() {

        return gameService.getGamesFromSteam();
    }

    @GetMapping("/listall")
    public ResponseEntity<List<GameResponse>> getAllSteamApps() {

        var games = gameService.getAllGamesFromDb();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping("/name")
    public ResponseEntity<GameResponse> getGameByName(@RequestBody final GameResponse gameName) {
        return ResponseEntity.ok(gameService.getGameByName(gameName.getName()));
    }


}
