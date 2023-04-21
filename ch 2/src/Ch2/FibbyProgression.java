package Ch2;

public class FibbyProgression extends AbstractPtogression {

    // instance variables
    protected long prev;

    // constructors

    public FibbyProgression() {this(0, 1);}
    public FibbyProgression(long first, long second) {
        super(second);
        prev = first;
    }

    protected void advance() {
        long temp = prev;
        prev = current;
        current =  current + temp;
    }


}
