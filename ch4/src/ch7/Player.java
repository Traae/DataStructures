package ch7;

import java.util.ArrayDeque;

public class Player {
    // instance variables
    private ArrayDeque<card> playerDeck;
    // constructor
    public Player() {
        playerDeck = new ArrayDeque<card>();
    }
    public void addCard(card c) {
        playerDeck.add(c);
    }
    // methods
    public String toString() {
        String sb = "";
        for (var card: playerDeck) {
            sb += card.getValue() + card.getSuit() + "\n";
        }
        return sb;
    }
    public int size() {return playerDeck.size();}

}
