package org.example.sii3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Сущность предмет
 * @author danya
 */

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String name;
    private int price;
}
