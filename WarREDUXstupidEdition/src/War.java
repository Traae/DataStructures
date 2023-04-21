// Traae Bloxham
// Dr. Kerby
// Data Structures and Algorithms
// 3/13/20

import java.util.Scanner;

public class War {
    // Instance variables
    private int numOfPlayers; // player num;
    private int numOfGames; // number of games
    private int gameCount;
    private Player[] players; // an array of players for variable game size.
    private Deck theDeck;
    // these variables will be used each game, and added to the corresponding average variable
    // the averages won't be calculated till the end, so they also function as a running total;
    private int turnsNum ;
    private int turnsAverage;
    private int warNum;  // how many wars
    private int warAverage;
    private int doubleWarNum;  // how many wars in wars
    private int doubleWarAverage;
    private int allOutWar;    // how many wars with all players
    private int allOutAverage;
    private int winner;
    private boolean isDoubleWar;
    private int tieGame;
    private int warLayerCount;
    private int currentLayer;

    // Constructor
    public War(int numPlayerIn, int numGamesIn) {
        // set the players and game numbers
        numOfPlayers = numPlayerIn;
        numOfGames = numGamesIn;
        gameCount = 0;
        tieGame = 0;
        // set the average variables to 0
        turnsAverage = 0;
        warAverage = 0;
        doubleWarAverage = 0;
        allOutAverage = 0;
        warLayerCount =0;
        currentLayer =0;
        // create players
        players = new Player[numOfPlayers];
        for (int i=0; i<numOfPlayers; i++) { players[i] = new Player(); }
        // creating the deck


    }

    public void setUpGame() {
        // set the game variable back to 0
        turnsNum = 0 ;
        warNum = 0 ;
        doubleWarNum = 0;
        allOutWar =0;
        winner = -1; // players listed in array 0 ~~ 3, so -1 is no winner yet
        // winner is used as player number (index + 1) 0 is a tie
        theDeck = new Deck();
        theDeck.shuffle();

        while (theDeck.size() > 0) {             //  for the number of cards divided by number of players
            for (var p : players) {    // deal a card to each player
                if (theDeck.size() == 0) { break; }
                else {p.addCard(theDeck.dealCard());}   // make sure the deck dosen't deal nothing
            }
        }
    }

    // put players cars back in the deck and tally the running totals
    public void cleanUpGame() {
        turnsAverage += turnsNum;
        warAverage += warNum;
        doubleWarAverage += doubleWarNum;
        allOutAverage += allOutWar;
    }

    // results for one game
    public void displayResults() {
        System.out.println(turnsNum + " turns");
        System.out.println(warNum + " wars");
        System.out.println(doubleWarNum + " Nested Wars");
        if (numOfPlayers > 2 ) {System.out.println(allOutWar + " All Out Wars"); }
        if (winner == 0) {
            tieGame ++;
            System.out.println("Cease Fire!");
        }
        else { System.out.println("Player " + winner + " Wins!"); }
    }

    // the totals and averages across all games
    public void totalResults() {
        System.out.println(" \n \n \n Across " + numOfGames + " games with " + numOfPlayers + " players, ");
        // all the average variable haven't been averaged yet, so they serve as a total;
        System.out.println(turnsAverage + " turns were played with");
        System.out.println(warAverage + " Wars, ");
        System.out.println(doubleWarAverage + " Nested Wars ");
        if (numOfPlayers > 2) {System.out.println(allOutAverage + " All Out Wars played.");}
        System.out.println("with ");

        turnsAverage /= numOfGames;
        warAverage /= numOfGames;
        doubleWarAverage /= numOfGames;
        allOutAverage /= numOfGames;

        System.out.println(turnsAverage + " turns, ");
        System.out.println(warAverage + " Wars, ");
        System.out.println(doubleWarAverage + " Nested Wars, ");
        if (numOfPlayers > 2) {System.out.println(allOutAverage + " All Out Wars");}
        System.out.println("on average per game");
        System.out.println("The Wars went " + warLayerCount + " layers deep.");
        System.out.println("There were " + tieGame + " Cease Fires.");
        for (int i=0; i<numOfPlayers; i++) {
            System.out.println("Player " + (i +1) + " won " + players[i].getWins() + " times");
        }
    }

    public void playAWar() {
        warNum++; // take care of the counters
        currentLayer++;
        if (currentLayer > warLayerCount) { warLayerCount = currentLayer; } // count how deep the wars go for the sim
        if (isDoubleWar) {doubleWarNum++;}
        isDoubleWar=true;
        // now, ante the war chest for each player
        for (var p: players) {
            if (p.getHighest())  {  // if the were marked highest
                if (p.size() == 1) {    // if the play has only 1 card they auto loose, because they have no more ware funds
                    theDeck.addCard(p.playCard()); // forfeit the last card
                }
                else if (p.size() >= 4) {   // the player ante's 3, and will compare the forth
                    theDeck.addCard(p.playCard());
                    theDeck.addCard(p.playCard());
                    theDeck.addCard(p.playCard());
                }
                else {        // if they have less then 4, the ante what the can, compare the last
                    while (p.size() > 1){ theDeck.addCard(p.playCard()); }
                }
            }
        }
        compareCards();
    }

    public void compareCards () {
        for (var p : players) { p.setHighest(false); } // reset players highest flag to false
        // compare cards
        int highCard = 0;
        for (int i = 0; i < numOfPlayers; i++) {
            if ((players[i].size() > 0) && (players[i].isAtWar())){  // if the player isn't out of the game & out of the turn
                int cardValue = players[i].revealCard(); // get card value
                if (highCard < cardValue) {  // if their card is bigger
                    highCard = cardValue;    // set the high value to their card
                    for (var p : players) {
                        p.setHighest(false);

                    }   // set everyone to low
                    players[i].setHighest(true); // set themselves as highest,

                }
                else if (highCard == cardValue) {   // tie the with highest
                    players[i].setHighest(true);
                }
                theDeck.addCard(players[i].playCard());  // they give up the card they revealed
            }
        }  // Player(s) should now be marked as either highest or not

        int iswar = 0;// need to count to determine if a war happens
        for (var p : players) {
            if (p.getHighest()) { // if marked highest, increment
                iswar++;
            }
            else {                  // if not highest, then no longer at war this turn
                p.setAtWar(false);
            }
        }
        if (iswar == numOfPlayers) {allOutWar++;} // if all the players are in the war,  All Out War
        if (iswar > 1) { playAWar();  }   // if their is a tie, go to war
        // add everyone's card to the deck
        for (var p : players) {   // find the highest player
            if (p.getHighest()) {
                while (theDeck.size() > 0) {  // then add all the cards to their deck
                    p.addCard(theDeck.dealCard());  // NOTE: I could add an addAll method, but, like, no.
                }
            }
        }
    }

    public void winCheck() {
        int stillPlaying=0;
        for (var p:players) {  // search to see if at least 2 are playing
            if (p.size() > 0) { stillPlaying++; }
        }
        if (stillPlaying == 1) {   // if only 1 person is in we have a winner
            for (int i=0; i<numOfPlayers; i++) {   // search for the winner
                if (players[i].size() > 0) {
                    winner = i + 1;  // set winner to their player number, not their index
                    players[i].victory(); // count their win
                }
            }
        }
    }

    public void playATurn() {
        for (var p: players) { p.setAtWar(true); } // set everyone's at war flag up, saying their still playing
        currentLayer =0;                    // set the double layer count to 0
        isDoubleWar = false;                // flip the double war flag down
        turnsNum++;                         // increment turn counter
        if ((turnsNum%10 == 0) && (turnsNum > 0)) {  // every ten turns, shuffle the players decks
            for (var p: players) {
                p.shuffle();                        // prevents stagnation and draws
            }
        }
        compareCards(); // recursively calls playAWar() until someone is crowned highest
        winCheck();
        if (turnsNum == 1000) {winner = 0;} // prevent infinite games. 0 counts as tie
    }

    public void playAGame() {   // plays a single game
        System.out.println("Game " + gameCount + ": ");
        setUpGame();           // set game values to their base
        while (winner < 0) { playATurn(); } // play turns until a winner exists
        displayResults();
        cleanUpGame();   // cleans up the cards
    }

    // plays multiple games and shows the total results of all of them
    public void runTheSim() {
        while (gameCount < numOfGames) {  // play games for the number of games input
            gameCount++;
            playAGame();
        }
        if (numOfGames > 1 ) {totalResults();}  // total results and averages
    }

    // main
    public static void main(String[] args) {
        // main menu, and number of players input
        System.out.println("Welcome to WAR... \nthe card game... \nthe simulation.");
        System.out.println("\n How many players do you want to simulate, \n 2-8: ");
        Scanner input = new Scanner(System.in);
        int numPlayerIn = input.nextInt();
        if ((numPlayerIn < 2) || (numPlayerIn > 8))  {
            System.out.println("YOU DONE GOOFED \n We're going with 2 instead");
            numPlayerIn =2;
        }
        // number of games to play
        System.out.println("\n How many games do you want to simulate, \n up to 10,000: ");
        int numGames = input.nextInt();
        if ((numGames < 1) || (numGames > 10000))  {
            System.out.println("YOU DONE GOOFED \n We're going with 1 instead");
            numGames = 1;
        }
        System.out.println(numPlayerIn + " player simulation for " + numGames + " games. \n GO! \n");
        War wargame = new War(numPlayerIn, numGames);
        wargame.runTheSim();
    }
}
