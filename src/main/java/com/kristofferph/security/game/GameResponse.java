package com.kristofferph.security.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {
    private Integer id;
    private Integer appid;
    private String name;
}
