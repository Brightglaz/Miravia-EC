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

public class Shop {
    private List<Item> itemsForSale;
    private List<Card> cardsForSale;
    private List<Equipment> equipmentForSale;
    private Scanner scanner;

    public Shop() {
        this.itemsForSale = new ArrayList<>();
        this.cardsForSale = new ArrayList<>();
        this.equipmentForSale = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public List<Item> getItemsForSale() {
        return itemsForSale;
    }

    public List<Card> getCardsForSale() {
        return cardsForSale;
    }

    public List<Equipment> getEquipmentForSale() {
        return equipmentForSale;
    }

    public void addItemForSale(Item item) {
        itemsForSale.add(item);
    }

    public void addCardForSale(Card card) {
        cardsForSale.add(card);
    }

    public void addEquipmentForSale(Equipment equipment) {
        equipmentForSale.add(equipment);
    }

    public void showItemsForSale() {
        System.out.println("Items for sale:");
        for (int i = 0; i < itemsForSale.size(); i++) {
            Item item = itemsForSale.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getDescription());
        }
    }

    public void showCardsForSale() {
        System.out.println("Cards for sale:");
        for (int i = 0; i < cardsForSale.size(); i++) {
            Card card = cardsForSale.get(i);
            System.out.println((i + 1) + ". " + card.getName() + " - " + card.getType() + " - " + card.getCost() + " money");
        }
    }

    public void showEquipmentForSale() {
        System.out.println("Equipment for sale:");
        for (int i = 0; i < equipmentForSale.size(); i++) {
            Equipment equipment = equipmentForSale.get(i);
            System.out.println((i + 1) + ". " + equipment.getName() + " - " + equipment.getBonusAttack() + " Attack, " + equipment.getBonusDefense() + " Defense");
        }
    }

    public void enterShop(Player player) {
        while (true) {
            System.out.println("Welcome to the Shop! What would you like to do?");
            System.out.println("1. Buy Item");
            System.out.println("2. Buy Card");
            System.out.println("3. Buy Equipment");
            System.out.println("4. Leave Shop");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                showItemsForSale();
                System.out.println("Which item would you like to buy? (Enter number or 0 to cancel)");
                int itemChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (itemChoice > 0 && itemChoice <= itemsForSale.size()) {
                    Item item = itemsForSale.get(itemChoice - 1);
                    // Assuming all items cost 10 money for simplicity
                    if (player.spendMoney(10)) {
                        player.getInventory().addItem(item);
                        System.out.println("You bought " + item.getName() + "!");
                    }
                }
            } else if (choice == 2) {
                showCardsForSale();
                System.out.println("Which card would you like to buy? (Enter number or 0 to cancel)");
                int cardChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (cardChoice > 0 && cardChoice <= cardsForSale.size()) {
                    Card card = cardsForSale.get(cardChoice - 1);
                    if (player.spendMoney(card.getCost())) {
                        player.getDeck().addCard(card);
                        System.out.println("You bought " + card.getName() + "!");
                    }
                }
            } else if (choice == 3) {
                showEquipmentForSale();
                System.out.println("Which equipment would you like to buy? (Enter number or 0 to cancel)");
                int equipmentChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (equipmentChoice > 0 && equipmentChoice <= equipmentForSale.size()) {
                    Equipment equipment = equipmentForSale.get(equipmentChoice - 1);
                    // Assuming all equipment costs 20 money for simplicity
                    if (player.spendMoney(20)) {
                        player.getInventory().equip(equipment);
                        System.out.println("You bought and equipped " + equipment.getName() + "!");
                    }
                }
            } else if (choice == 4) {
                System.out.println("Thank you for visiting the shop! Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
