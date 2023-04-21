package Ch2;

public class GeometricProg extends AbstractPtogression {
    // instance variables
    protected long multiplier;

    // constructors
    public GeometricProg() {this(2,1);}
    public GeometricProg(long m) {this(m, 1);}
    public GeometricProg(long m, long start) {
        super(start);
        multiplier = m;
    }
    protected void advance() {
        current *= multiplier;
    }
}
