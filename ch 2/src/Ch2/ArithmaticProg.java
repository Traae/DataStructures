package Ch2;

public class ArithmaticProg extends AbstractPtogression {
    // additional instance variables
    protected long increment;

    // constructor
    public ArithmaticProg() { this(1, 0);}
    public ArithmaticProg(long stepsize) { this(stepsize, 0);}
    public ArithmaticProg(long stepsize, long start) {
        super(start); // calls Progression(start) constructor
        increment = stepsize;
    }
    protected void advance() {
        current += increment;
    }

}
