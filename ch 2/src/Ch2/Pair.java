package Ch2;

public class Pair<A,B> {
    // instance variables
    A first;
    B second;

    // constructor
    public Pair(A a, B b) {
        first = a;
        second = b;
    }

    // methobs
    public A getFirst() { return first;}
    public B getSecond() { return second;}
    public String toString() {
        return "[" + first +", " + second + "]";
    }

    public static void main (String[] args) {
        // ssassafrass
        Pair<String,Double> bid;
        bid = new Pair<String,Double>("ORCL", 5.00);

        System.out.println(bid.toString());

        Pair<Double,Double> point = new Pair<>(4.2,5.6);
        System.out.println(point);
    }
}
