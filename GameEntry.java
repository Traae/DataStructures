package Ch3;

public class GameEntry {  // Note that we could have used our generic Pair<>
    // Instance variables
    private String name;
    private int score;

    // Constructors
    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }

    // Methods
    public String getName() { return name; }
    public int getScore() { return score; }
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}
