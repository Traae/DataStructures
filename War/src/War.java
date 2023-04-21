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
    private Player[] players; // initilize an array of players for variable game size.
    private Deck theDeck;
    // the variable will be used each game, and added to the corresponding average variable
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
    private int NestedCount;


    // Constructor
    public War(int numPlayerIn, int numGamesIn) {

        // set the players and game numbers
        numOfPlayers = numPlayerIn;
        numOfGames = numGamesIn;
        gameCount = 0;
        // set the average variables to 0
        turnsAverage = 0;
        warAverage = 0;
        doubleWarAverage = 0;
        allOutAverage = 0;

        // creating the players
        players = new Player[numOfPlayers];
        for (int i=0; i<numOfPlayers; i++) {
            players[i] = new Player();
        }

        // creating the deck
        theDeck = new Deck();

    }

    public void setUpGame() {
        // set the game variable back to 0
        turnsNum = 0 ;
        warNum = 0 ;
        doubleWarNum = 0;
        allOutWar =0;
        winner = -1; // players listed in array 0 ~~ 3, so -1 is no winner yet

        theDeck.shuffle();

        int cardsPer = 54 / numOfPlayers;
        for (int i=0; i<cardsPer; i++) {             //  for the number of cards divided by number of players
            for (int j=0; j<numOfPlayers; j++) {    // deal a card to each player
                if (theDeck.size() > 0) { players[j].addCard(theDeck.dealCard()); }
            }
        }
    }

    // put players cars back in the deck and tally the running totals
    public void cleanUpGame() {
        turnsAverage += turnsNum;
        warAverage += warNum;
        doubleWarAverage += doubleWarNum;
        allOutAverage += allOutWar;

        for (int i=0; i<numOfPlayers; i++) {    // only 1 player should have cards, but the while won't run anyways
            while (players[i].size() != 0) {          // remove cards from their deck and add it back to The Deck
                if (players[i].size() >0 ) { theDeck.addCard(players[i].playCard()); };
            }
        }
    }

    // results for one game
    public void displayResults() {
        System.out.println(turnsNum + " turns");
        System.out.println(warNum + " wars");
        System.out.println(doubleWarNum + " Nested Wars");
        if (numOfPlayers > 2 ) {System.out.println(allOutWar + " All Out Wars"); }
        System.out.println("Player " + winner + " Wins!");
    }

    // the totals and averages across all games
    public void totalResults() {
        System.out.println(" \n \n \n Across " + numOfGames + " games with " + numOfPlayers + " players, ");
        // all the average variable haven't been averaged yet, so they serve as a total;
        System.out.println(turnsAverage + " turns were played with");
        System.out.println(warAverage + " Wars, ");
        System.out.println(doubleWarAverage + " Nested Wars, and");
        System.out.println(allOutAverage + " All Out Wars played. \n with ");
        turnsAverage /= numOfGames;
        warAverage /= numOfGames;
        doubleWarAverage /= numOfGames;
        allOutAverage /= numOfGames;
        System.out.println(turnsAverage + " turns, ");
        System.out.println(warAverage + " Wars, ");
        System.out.println(doubleWarAverage + " Nested Wars, and");
        System.out.println(allOutAverage + " All Out Wars on average per game");
        for (int i=0; i<numOfPlayers; i++) {
            System.out.println("Player " + (i +1) + " won " + players[i].getWins() + " times");
        }
    }

    public void playAWar(Player[] pToWar) {
        // first take care of the statistic
        warNum++;
        if (isDoubleWar) {
            doubleWarNum++;
            NestedCount++;
            //System.out.println("War has gone: " + NestedCount + " Layers deep.");
        }
        isDoubleWar = true; // trip this flag the first time, after that it counts  playATurn() resets
        if (pToWar.length == numOfPlayers) { allOutWar++;}

        // now, ante the war chest for each player
        for (int i=0; i<pToWar.length; i++) {
            //System.out.println("in side p :ptowar, size(): " + p.size() + "and p " +p);
            int anteSize = pToWar[i].size();
            if (anteSize == 1) {    // if the play has only 1 card the auto loose,
                pToWar[i].isHighest=false;  // put the flag down
                theDeck.addCard(pToWar[i].playCard()); // forfeit the last card
            }
            else if (anteSize >= 4) {
                theDeck.addCard(pToWar[i].playCard());
                theDeck.addCard(pToWar[i].playCard());
                theDeck.addCard(pToWar[i].playCard());
            }
            else {
                for (int j=0; j<anteSize-1; j++){
                    if (pToWar[i].size() >0 ) { theDeck.addCard(pToWar[i].playCard()); }
                }
            }

        }

        // now rebuild the list removing  any losers
        int stillinWar = 0;
        for (var p : pToWar) {   // count how many players are still playing
            if (p.isHighest){
                stillinWar++;
            }
        }
        Player[] pToPass = new Player[stillinWar];   // create an array for those players
        for (int i=0; i<pToPass.length; i++) {
            if (pToWar[i].isHighest){
                pToPass[stillinWar-1] = pToWar[i];    // if they're highest add them
                stillinWar--;             // going to war counts down to reconcile the possible difference in index size.
            }
        }
        // now that the players have ante'd up, recursively pass them to compare cards again
        compCards(pToPass);
    }

    public void compCards (Player[] pToCompare) {

        for (var p : pToCompare) { p.isHighest = false; } // resets the players highest flag
        Card[] cardsCompare = new Card[pToCompare.length];     // create an array to hold the cards
        for (int i=0; i<pToCompare.length; i++) {       // grab the cards
            cardsCompare[i] = pToCompare[i].playCard();
            //System.out.println(cardsCompare[i].getValue());
        }

        // search through and find the highest value
        int highestValue = 0;
        boolean isWar = false;
        for (int i=0; i<pToCompare.length; i++){
            if (cardsCompare[i].getValue() > highestValue) {
                highestValue = cardsCompare[i].getValue();
                pToCompare[i].isHighest = true;      // if the player had the highest, trip their flag
                if (i > 0) {pToCompare[i-1].isHighest = false;}  // if they weren't the first, reset the person they topped.
            }
            else if (cardsCompare[i].getValue() == highestValue) {
                pToCompare[i].isHighest = true;
                isWar = true;
            }
        }

        // if there is a war, build an array to pass fr that comparison
        if (isWar) {
            int goingToWar = 0;
            for (var p : pToCompare) {   // count how many players are still playing
                if (p.isHighest){
                    goingToWar++;
                }
            }
            Player[] pToPass = new Player[goingToWar];   // create an array for those players
            for (int i=0; i<pToPass.length; i++) {
                if (pToCompare[i].isHighest){
                    pToPass[goingToWar-1] = pToCompare[i];    // if they're highest add them
                    goingToWar--;             // going to war counts down to reconcile the possible difference in index size.
                }
            }
            // pass all the players to be compared;
            playAWar(pToPass);
        }

        // now that were done comparing cards, add them to the deck
        for (var c : cardsCompare) {
            theDeck.addCard(c);
        }
        theDeck.shuffle();
        // now find the p that had the highest card and give them all the cards in play
        for (var p : pToCompare) {
            if (p.isHighest) {
                while (theDeck.size() != 0){
                    p.addCard(theDeck.dealCard());
                }
            }
        }
    }

    public void winCheck() {
        int stillInCount = 0;
        for (var p : players) {   // count how many players are still playing
            if (p.size() != 0){
                stillInCount++;
            }
        }
        if (stillInCount == 1) {    // if their is a winner,
            for (int i=0; i<numOfPlayers; i++) {
                if (players[i].size() != 0) {
                    winner = i + 1;   //set winner variable to their player number
                    players[i].victory();  // and increment their win count
                }
            }
        }
    }

    public void playATurn() {
        isDoubleWar = false; // first war trip this flag. will be reset each turn
        NestedCount = 0;
        int stillInCount = 0;
        for (var p : players) {   // count how many players are still playing
            if (p.size() != 0){
                stillInCount++;
            }
        }
        Player[] pToPass = new Player[stillInCount];   // create an array for those players
        for (int i=0; i<numOfPlayers; i++) {
            if (players[i].size() != 0){
                pToPass[stillInCount-1] = players[i];    // if they're still playing add them
                stillInCount--;             // stillInCount counts down to reconcile the possible difference in index size.
            }
        }
        // pass all the players to be compared;
        compCards(pToPass);

        // finish the turn
        turnsNum++;
        winCheck();
    }

    public void playAGame() {   // plays a single game
        System.out.println("Game " + gameCount + ": ");
        setUpGame();           // set game values to their base
        while (winner < 0) {   // play turns until a winner exists
            playATurn();
        }
        displayResults();
        cleanUpGame();   // cleans up the cards
    }

    // plays multiple games and shows the total results of all of them
    public void runTheSim() {
        while (gameCount < numOfGames) {  // play games for the number of games inputed
            gameCount++;
            playAGame();
        }
        if (numOfGames > 1 ) {totalResults();}  // total results and averages
    }

    // main
    public static void main(String[] args) {
        // main menu, and number of players input
        System.out.println("Welcome to WAR... \nthe card game... \nthe simulation.");
        System.out.println("\n How many players do you want to simulate, \n 2, 3, or 4: ");
        Scanner input = new Scanner(System.in);
        int numPlayerIn = input.nextInt();
        if ((numPlayerIn < 2) || (numPlayerIn > 4))  {
            System.out.println("YOU DONE GOOFED \n We're going with 2 instead");
            numPlayerIn =2;
        }

        // number of games to play
        System.out.println("\n How many games do you want to simulate, \n up to 1000: ");
        int numGames = input.nextInt();
        if ((numGames < 1) || (numGames > 1000))  {
            System.out.println("YOU DONE GOOFED \n We're going with 1 instead");
            numGames =1;
        }

        System.out.println(numPlayerIn + " player simulation for " + numGames + " games. \n GO! \n");
        War wargame = new War(numPlayerIn, numGames);
        wargame.runTheSim();

    }
}
