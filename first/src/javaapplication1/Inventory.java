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

public class Inventory {
    private List<Item> items;
    private List<Card> cards;
    private Equipment[] equipment;

    public Inventory() {
        this.items = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.equipment = new Equipment[4]; // 0: Helmet, 1: Armor, 2: Weapon, 3: Boots
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Equipment[] getEquipment() {
        return equipment;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void equip(Equipment equipment) {
        if (equipment instanceof Helmet) {
            this.equipment[0] = equipment;
        } else if (equipment instanceof Armor) {
            this.equipment[1] = equipment;
        } else if (equipment instanceof Weapon) {
            this.equipment[2] = equipment;
        } else if (equipment instanceof Boots) {
            this.equipment[3] = equipment;
        }
    }

    public void unequip(Equipment equipment) {
        for (int i = 0; i < this.equipment.length; i++) {
            if (this.equipment[i] == equipment) {
                this.equipment[i] = null;
            }
        }
    }
}

abstract class Equipment {
    private String name;
    private int bonusAttack;
    private int bonusDefense;

    public Equipment(String name, int bonusAttack, int bonusDefense) {
        this.name = name;
        this.bonusAttack = bonusAttack;
        this.bonusDefense = bonusDefense;
    }

    public String getName() {
        return name;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }
}

class Helmet extends Equipment {
    public Helmet(String name, int bonusAttack, int bonusDefense) {
        super(name, bonusAttack, bonusDefense);
    }
}

class Armor extends Equipment {
    public Armor(String name, int bonusAttack, int bonusDefense) {
        super(name, bonusAttack, bonusDefense);
    }
}

class Weapon extends Equipment {
    public Weapon(String name, int bonusAttack, int bonusDefense) {
        super(name, bonusAttack, bonusDefense);
    }
}

class Boots extends Equipment {
    public Boots(String name, int bonusAttack, int bonusDefense) {
        super(name, bonusAttack, bonusDefense);
    }
}

class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
