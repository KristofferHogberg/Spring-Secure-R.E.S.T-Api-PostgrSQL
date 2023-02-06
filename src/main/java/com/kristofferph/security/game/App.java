package com.kristofferph.security.game;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonSerialize(using = CustomAppSerializer.class)
public class App {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer appid;
    private String name;
}
