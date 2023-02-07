package com.kristofferph.security.game;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
public class App {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer appid;
    @Column
    private String name;
}
