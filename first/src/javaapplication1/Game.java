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
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Player player;
    private List<Enemy> enemies;
    private Shop shop;
    private Scanner scanner;
    private Random random;

    public Game(Player player, Shop shop) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.shop = shop;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void startGame() {
        System.out.println("Welcome to the RPG Card Game!");
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Fight Enemies");
            System.out.println("2. Visit Shop");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit Game");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                fightEnemies();
            } else if (choice == 2) {
                shop.enterShop(player);
            } else if (choice == 3) {
                // Here you can add code to view and manage the player's inventory
                System.out.println("Inventory viewing and management feature is not implemented yet.");
            } else if (choice == 4) {
                System.out.println("Thank you for playing! Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private void fightEnemies() {
        System.out.println("Get ready to fight!");
        // Generate enemies based on player's level
        int enemyCount = random.nextInt(3) + 1; // 1 to 3 enemies
        for (int i = 0; i < enemyCount; i++) {
            int level = player.getLevel();
            if (random.nextBoolean()) { // 50% chance to get an enemy of higher level
                level++;
            }
            enemies.add(new Enemy("Enemy " + (i + 1), level));
        }

        System.out.println("You will be fighting " + enemyCount + " enemies!");
        // Battle loop
        while (!enemies.isEmpty()) {
            System.out.println("\nYour turn! Choose an action:");
            System.out.println("1. Attack");
            System.out.println("2. Use Card");
            System.out.println("3. Run Away");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                player.attack(enemies.get(0)); // Attack the first enemy for simplicity
                if (enemies.get(0).getHealth() <= 0) {
                    System.out.println(enemies.get(0).getName() + " has been defeated!");
                    enemies.remove(0);
                }
            } else if (choice == 2) {
                // Here you can add code to use a card
                System.out.println("Card usage feature is not implemented yet.");
            } else if (choice == 3) {
                System.out.println("You ran away!");
                break;
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
                continue;
            }

            // Enemy turn
            for (Enemy enemy : enemies) {
                enemy.attack(player);
                if (player.getHealth() <= 0) {
                    System.out.println("You have been defeated! Game Over!");
                    System.exit(0);
                }
            }

            // End of turn
            player.endTurn();
            for (Enemy enemy : enemies) {
                enemy.endTurn();
            }
        }

        System.out.println("Battle won! You earned 50 XP and 20 money!");
        player.earnXP(50);
        player.earnMoney(20);
    }
}
