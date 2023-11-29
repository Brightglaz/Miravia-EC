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
public abstract class Character {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int poisonDuration;
    protected int stunDuration;

    public Character(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.poisonDuration = 0;
        this.stunDuration = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getPoisonDuration() {
        return poisonDuration;
    }

    public void setPoisonDuration(int poisonDuration) {
        this.poisonDuration = poisonDuration;
    }

    public int getStunDuration() {
        return stunDuration;
    }

    public void setStunDuration(int stunDuration) {
        this.stunDuration = stunDuration;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public void applyPoison() {
        if (poisonDuration > 0) {
            takeDamage(5); // Assume poison deals 5 damage per turn
            poisonDuration--;
        }
    }

    public void endTurn() {
        applyPoison();
        if (stunDuration > 0) stunDuration--;
    }
}

class Player extends Character {
    private int level;
    private int xp;
    private int money;
    private Deck deck;
    private Inventory inventory;
    private Pet pet;

    public Player(String name, int health, int attack, int defense, Deck deck, Inventory inventory) {
        super(name, health, attack, defense);
        this.level = 1;
        this.xp = 0;
        this.money = 100;
        this.deck = deck;
        this.inventory = inventory;
        this.pet = null;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getMoney() {
        return money;
    }

    public Deck getDeck() {
        return deck;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    public void earnXP(int amount) {
        xp += amount;
        System.out.println("You earned " + amount + " xp");
    }

    public void earnMoney(int amount) {
        money += amount;
        System.out.println("You earned " + amount + " money! Total money: " + money);
    }

    public boolean spendMoney(int amount) {
        if (amount > money) {
            System.out.println("Not enough money!");
            return false;
        }
        money -= amount;
        System.out.println("You spent " + amount + " money. Remaining money: " + money);
        return true;
    }

    public void attack(Character target) {
        if (stunDuration > 0) {
            System.out.println("You are stunned and cannot move this turn!");
            return;
        }
        int damage = attack - target.getDefense();
        if (damage < 0) damage = 0;
        target.takeDamage(damage);
        System.out.println("You attacked the enemy for " + damage + " damage!");
    }

    public void levelUp() {
        level++;
        xp = 0;
        health += 10;
        attack += 5;
        defense += 5;
        System.out.println("Congratulations! You leveled up to level " + level + "!");
    }
}

class Enemy extends Character {
    private int level;

    public Enemy(String name, int level) {
        super(name, level * 20, level * 5, level * 5);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void attack(Player player) {
        if (stunDuration > 0) {
            System.out.println("The enemy is stunned and cannot move this turn!");
            return;
        }
        int damage = attack - player.getDefense();
        if (damage < 0) damage = 0;
        player.takeDamage(damage);
        System.out.println("The enemy attacked you for " + damage + " damage!");
    }
}

class Pet extends Character {
    private int levelRequired;

    public Pet(String name, int health, int attack, int defense, int levelRequired) {
        super(name, health, attack, defense);
        this.levelRequired = levelRequired;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public void attack(Enemy enemy) {
        int damage = attack - enemy.getDefense();
        if (damage < 0) damage = 0;
        enemy.takeDamage(damage);
        System.out.println("Your pet attacked the enemy for " + damage + " damage!");
    }
}
