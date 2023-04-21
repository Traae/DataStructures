// Traae Bloxham
// Dr. Kerby
// Data Structures and Algorithms
// 3/13/20

import java.util.ArrayDeque;
import java.util.Random;

public class Player {
    // Instance variables
    private ArrayDeque<Card> playerdeck;// the players deck
    private int deckSize;       // personal variable for tracking deck size
    private int wins;                     // track total wins in sim
    private boolean isHighest;   // bool, False is low card - True is highest
    private boolean atWar; // along with deck size, determins if the player is still in

    // Constructor
    public Player() {
        playerdeck = new ArrayDeque<Card>(); // Construct w/ empty deck
        wins = 0;
        isHighest = false;
        atWar = false;
        deckSize = 0;
    }

    // Methods
    public void addCard(Card c) {
        deckSize++;
        playerdeck.addLast(c);
    }

    public int revealCard() { return playerdeck.peekFirst().getValue(); }

    public Card playCard() {
        if (deckSize > 0) {
            deckSize--;
            return playerdeck.removeFirst();
        }
        return null;
    }

    public String toString() {
        String sb = "PLAYER: ";
        for (var card : playerdeck) {
            sb += card.getValue() + card.getSuit() + " ";
        }
        sb += " " + wins + " " + " SIZE: " + deckSize;
        return sb;
    }

    public void shuffle() {
        Random rand = new Random();
        int switcher;
        ArrayDeque<Card> shuffleTemp = new ArrayDeque<>();
        for (int i=0; i<(deckSize*3); i++) {
            switcher = rand.nextInt(3);
            if (switcher == 0) { this.addCard(this.playCard());  }
            else if (switcher == 1) { shuffleTemp.addLast(this.playCard());}
        }
        playerdeck.addAll(shuffleTemp);
    }

    // simple set and gets
    public int size() { return deckSize; }
    public void victory() { wins++; }
    public int getWins() { return wins; }
    public void setHighest(boolean b) {isHighest = b;}
    public boolean getHighest() { return isHighest;}
    public void setAtWar(boolean b) { atWar = b; }
    public boolean isAtWar() {return atWar;}
}
