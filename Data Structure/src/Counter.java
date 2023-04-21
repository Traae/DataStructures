public class Counter {
    private int count; //just an integer variable
    // contructors
    public Counter() {}
    public Counter(int initial) { count = initial;}

    // methodsfunctions
    public int getcount() { return count;}
    public void setCount(int newValue) {count = newValue;}
    public void increment() {count++;}
    public void increment( int addedValue) {count += addedValue;}
    public void reset() {count = 0;}
}
