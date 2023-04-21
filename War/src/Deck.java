// Traae Bloxham
// Dr. Kerby
// Data Structures and Algorithms
// 3/13/20

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    // Instance variables
    private ArrayList<Card> deck;
    // Constructor
    public Deck() {
        deck = new ArrayList<Card>(54);
        String[] suits = {"H","D","S","C"};
        // Add 52 cards, 2-A for each of the four suits
        for (var suit : suits) {
            for (int i = 2; i <= 14; i++) {
                Card card = new Card(i, suit);
                deck.add(card);
            }
        }
        // Add Jokers
        Card card = new Card(15,"J");
        deck.add(card);
        deck.add(card);

    }
    // Methods
    public String toString() {
        String sb = "";
        for (var card : deck) {
            sb += card.getValue() + card.getSuit() + "\n";
        }
        return sb;
    }
    public int size() { return deck.size(); }
    public void shuffle() {
        Collections.shuffle(deck);
    }
    public Card dealCard() {
        if (deck.size() != 0) {
            return deck.remove(0);
        }
        return null;
    }
    public void addCard(Card c) { deck.add(c);  }
}
