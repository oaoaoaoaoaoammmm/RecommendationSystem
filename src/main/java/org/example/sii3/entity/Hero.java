package org.example.sii3.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Сущность герой
 * @author danya
 */
@Getter
@Setter
@AllArgsConstructor
public class Hero {
    private String name;
    private Team team;
    private Role role;
    private Hero dangerHero;
    private List<Item> items;
    private List<Item> dangerItems;
}
