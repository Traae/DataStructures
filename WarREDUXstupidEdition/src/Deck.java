// Traae Bloxham
// Dr. Kerby
// Data Structures and Algorithms
// 3/13/20

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    // Instance variables
    private ArrayList<Card> deck;
    private int deckSize;
    // Constructor
    public Deck() {
        deck = new ArrayList<Card>(54);
        String[] suits = {"H","D","S","C"};
        // Add 52 cards, 2-A for each of the four suits
        for (var suit : suits) {
            for (int i = 2; i <= 14; i++) {
                Card card = new Card(i, suit);
                deck.add(0, card);
            }
        }
        // Add Jokers
        Card card = new Card(15,"J");
        deck.add(0, card);
        deck.add(0, card);
        deckSize=54;
    }
    // Methods
    public String toString() {
        String sb = "DECK : ";
        for (var c : deck) {
            sb += c.getValue() + c.getSuit() + " ";
        }
        sb += " SIZE: " + deck.size();
        return sb;
    }
    public int size() { return deckSize; }
    public void shuffle() {
        Collections.shuffle(deck);
    }
    public Card dealCard() {
        deckSize--;
        return deck.remove(0);
    }
    public void addCard(Card c) {
        deckSize++;
        deck.add(c);
    }
}
