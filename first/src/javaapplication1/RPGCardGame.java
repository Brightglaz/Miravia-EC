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
public class RPGCardGame {
    public static void main(String[] args) {
        // Initialize Deck and Inventory
        Deck deck = new Deck();
        Inventory inventory = new Inventory();

        // Add some sample cards to the deck
        deck.addCard(new Card("Attack 100%", CardType.ATTACK, 100, 10, false, false));
        deck.addCard(new Card("Attack 150%", CardType.ATTACK, 150, 15, false, false));
        deck.addCard(new Card("Heal", CardType.HEAL, 50, 10, false, false));
        deck.addCard(new Card("Buff", CardType.BUFF, 20, 10, false, false));
        deck.addCard(new Card("Ultimate", CardType.ULTIMATE, 200, 30, false, false));

        // Initialize Player with sample data
        Player player = new Player("Hero", 100, 20, 10, deck, inventory);

        // Initialize Shop with some sample items and equipment
        Shop shop = new Shop();
        shop.addItemForSale(new Item("Health Potion", "Restores 20 health"));
        shop.addEquipmentForSale(new Helmet("Iron Helmet", 0, 5));
        shop.addEquipmentForSale(new Armor("Iron Armor", 0, 10));
        shop.addEquipmentForSale(new Weapon("Iron Sword", 10, 0));
        shop.addEquipmentForSale(new Boots("Iron Boots", 0, 5));

        // Start the Game
        Game game = new Game(player, shop);
        game.startGame();
    }
}
