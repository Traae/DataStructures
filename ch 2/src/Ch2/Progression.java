package Ch2;

public class Progression {
    // instance variables n'shit
    protected long current;

    // constructors
    public Progression() {this(0);}
    public Progression(long start) {current = start;}

    // Methods
    public long nextValue () {
        advance();
        return current;
    }
    protected void advance () { current++; }
    public void printProgression(int n) {
        System.out.println("Current value = " + current + " ");
        System.out.println("Next " + n + " Values: ");
        for (int i = 0; i < n; i++) {
            System.out.println(nextValue() + " ");
        }
        // System.out.println();
    }
}
