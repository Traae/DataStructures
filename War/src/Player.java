// Traae Bloxham
// Dr. Kerby
// Data Structures and Algorithms
// 3/13/20

import java.util.ArrayDeque;

public class Player {
    // Instance variables
    private ArrayDeque<Card> playerdeck;  // the players deck
    private int wins;                     // track total wins in sim
    public boolean isHighest;           // a flag used for wars
    // Constructor
    public Player() {
        playerdeck = new ArrayDeque<Card>(); // Construct w/ empty deck
        wins = 0;
        isHighest = false;
    }
    // Methods
    public void addCard(Card c) {
        playerdeck.addLast(c);
    }
    public int revealCard() {
        Card current = playerdeck.peekFirst();
        return current.getValue();
    }
    public Card playCard() {
        if (playerdeck.size() != 0) {
            return playerdeck.removeFirst();
        }
        return null;
    }

    public String toString() {
        String sb = "";
        for (var card : playerdeck) {
            sb += card.getValue() + card.getSuit() + "\n";
        }
        sb += " " + wins + " " + isHighest;
        return sb;
    }
    public int size() { return playerdeck.size(); }
    public void victory() { wins++; }
    public int getWins() { return wins; }
}
