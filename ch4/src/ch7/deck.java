package ch7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class deck {
    // Instance variables
    private ArrayList<card> deck;
    public deck () {
        deck = new ArrayList<card>(54);
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds" };
        for (var suit : suits) {
            for (int i = 2; i <= 14; i++) {
                card newCard = new card(i, suit);
                deck.add(newCard);
            }

        }
        card newCard = new card(15, "Joker");
        deck.add(newCard);
        deck.add(newCard);
    }
    public String toString() {
        String sb = "";
        for (var card: deck) {
            sb += card.getValue() + card.getSuit() + "\n";
        }
        return sb;
    }
    public void shuffle() {
        Collections.shuffle(deck);
    }
    public card dealCard() {
        if (deck.size() != 0 ) { return deck.remove(0);}
        return null;
    }

    // methods/Functions
}
