package Ch2;

public abstract class AbstractPtogression {
    // instance variables n'shit
    protected long current;

    // constructors
    public AbstractPtogression() {this(0);}
    public AbstractPtogression(long start) {current = start;}

    // Methods
    public long nextValue () {   // implemented concrete
        advance();
        return current;
    }
    protected abstract void advance ();

    public void printProgression(int n) {
        System.out.println("Current value = " + current + " ");
        System.out.println("Next " + n + " Values: ");
        for (int i = 0; i < n; i++) {
            System.out.println(nextValue() + " ");
        }
        // System.out.println();
    }
}
