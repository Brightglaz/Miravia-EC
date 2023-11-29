/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Anaz
 */
import java.util.List;
import java.util.ArrayList;

enum CardType {
    ATTACK, DEFEND, HEAL, BUFF, ULTIMATE, ITEM
}

public class Card {
    private String name;
    private CardType type;
    private int value;
    private int cost;
    private boolean isStun;
    private boolean isPoison;

    public Card(String name, CardType type, int value, int cost, boolean isStun, boolean isPoison) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.cost = cost;
        this.isStun = isStun;
        this.isPoison = isPoison;
    }

    public String getName() {
        return name;
    }

    public CardType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }

    public boolean isStun() {
        return isStun;
    }

    public boolean isPoison() {
        return isPoison;
    }
}
