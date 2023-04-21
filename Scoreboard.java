package Ch3;

import java.util.Random;
import java.util.Arrays;

public class Scoreboard {
    // Instance variables
    private int numEntries = 0;
    private GameEntry[] board;  // This is composition (generally better)

    // Constructor
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    // Methods
    public void add(GameEntry e) { // Try to add new high score
        int newScore = e.getScore();
        // Check if the new score is a high score
        if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }
            int j = numEntries - 1;
            while (j > 0 && board[j-1].getScore() < newScore) {
                board[j] = board[j-1];
                j--;
            }
            board[j] = e;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry temp = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j+1];
        }
        board[numEntries-1] = null;
        numEntries--;
        return temp;
    }

    public String toString() {
        String sb = "Scoreboard: \n";
        for (int i = 0; i < numEntries; i++) {
            sb += (i+1) + ". " + board[i].getName() + "   " + board[i].getScore() + "\n";
        }
        return sb;
    }

    public static void main(String[] args) {
        Scoreboard highscores = new Scoreboard(10);
        String[] names = {"Eric", "Autumn", "Logan", "Joseph", "Austin",
                "John", "Kallie", "Emily", "Leslie", "Grant"};
        Random rand = new Random();
        int[] scores = new int[10];
        rand.setSeed(System.currentTimeMillis());
        //System.out.println(rand.nextInt(3));
        System.out.println(Arrays.asList(names));
        for (int i = 0; i < 10; i++) {
            scores[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(scores));
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));
        //Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));

        // Create GameEntries and add to Scoreboard
        for (int i = 0; i < 10; i++) {
            GameEntry ge = new GameEntry(names[i],scores[i]);
            System.out.println(ge);
            highscores.add(ge);
        }
        System.out.println(highscores);
        // Add another score
        highscores.add(new GameEntry("Leslie",99));
        System.out.println(highscores);
        // Remove a score
        highscores.remove(0);
        System.out.println(highscores);
    }
}
