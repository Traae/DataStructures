package ch7;

public class card {
    private int value; // 2 - j as 2 - 15
    private String suit;
        // constructor
    public card (int v, String s) {
        value = v;
        suit = s;
    }
    public int getValue() { return value;}
    public String getSuit() { return suit;}

}
