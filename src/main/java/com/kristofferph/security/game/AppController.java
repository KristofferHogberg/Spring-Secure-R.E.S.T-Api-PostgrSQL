package com.kristofferph.security.game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

//    @GetMapping("/list")
//    public ResponseEntity<String> getAllApps() {
//
//        var games = gameService.getAllApps();
//        String jsonStr = games.getBody();
//        Gson gson = new GsonBuilder().create();
//        App app = gson.fromJson(jsonStr, App.class);
//
//        System.out.println(app);
//
//        return games;
//
//    }

    @GetMapping("/list")
    public  ResponseEntity<String> getAllApps() {

        var applist = appService.getAllApps();

        return applist;

    }

}
