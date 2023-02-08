package com.kristofferph.security.game;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app")
public class Game {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer appid;
    @Column
    private String name;
}
