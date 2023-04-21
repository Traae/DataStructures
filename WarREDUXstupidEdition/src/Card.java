// Traae Bloxham
// Dr. Kerby
// Data Structures and Algorithms
// 3/13/20


public class Card {
    // Instance variables
    private int value = 1; // will represent 2-A as 2-14 integer, joker is 15
    private String suit = "None"; // will represent suit
    // Constructor
    public Card(int v, String s) {
        value = v;
        suit = s;
    }
    // Methods
    public int getValue() { return value; }
    public String getSuit() { return suit; }
}
