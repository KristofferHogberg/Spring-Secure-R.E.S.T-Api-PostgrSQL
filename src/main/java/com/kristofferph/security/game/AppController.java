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
public class AppController {

    private final AppService appService;

    @GetMapping("/loadapps")
    public ResponseEntity<ArrayList<AppResponse>> getAppsFromSteam() {

        return appService.getAppsFromSteam();
    }

    @GetMapping("/listall")
    public ResponseEntity<List<AppResponse>> getAllSteamApps() {

        var apps = appService.getAllAppsFromDb();
        return ResponseEntity.ok().body(apps);
    }

}
