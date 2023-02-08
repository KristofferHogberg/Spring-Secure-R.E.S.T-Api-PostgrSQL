package com.kristofferph.security.notion;

import com.kristofferph.security.config.NotionConfigProperties;
import com.kristofferph.security.user.UserResponse;
import com.kristofferph.security.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/notion")
@RequiredArgsConstructor
public class NotionController {

    private final UserService userService;
    private final NotionConfigProperties notionConfig;

    @GetMapping("/list")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/properties")
    public ResponseEntity<?> printAllProps() {
        System.out.print("Nu e vi härrr" + notionConfig.secretKey());
        try {
            var test =Map.of("secretKey", notionConfig.secretKey(),
                    "databaseUrl", notionConfig.databaseUrl(),
                    "username", notionConfig.username(),
                    "password", notionConfig.password());
        return ResponseEntity.ok(test);
        } catch (Exception e ){
            System.out.print(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad boiiii");
        }
    }

}