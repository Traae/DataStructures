package ch7;

public class War {
    public deck Mydeck;
    public War() {
        initialize();

        // initialize
        // create deck
        // deal cards
        // play
        // placing cards
        // dealing with wars
        // knowing when a pplayer has lost


        // report
        // number of turns
        // number of wars
        // winner


    }
    protected void initialize () {
        Mydeck = new deck();
        Mydeck.shuffle();
        Player player1 = new Player();
        Player player2 = new Player();
        for (int i=0; i < 27; i++) {
            player1.addCard(Mydeck.dealCard());
            player2.addCard(Mydeck.dealCard());
        }
        System.out.println(Mydeck.toString());
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
    public static void main(String[] args) {
        War wargame = new War();

    }
}
