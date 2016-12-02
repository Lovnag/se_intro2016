import java.util.Scanner;

/**
 * Created by thy humble Lovnag on 20.11.2016.
 */
public class RunningTheGame {

    public RunningTheGame() {
    }

    public void run() {

        Scanner in = new Scanner(System.in);
        System.out.println("Greetings, dear GameMaster. Dear GameMaster, please enter the number of players:");
        int numbOfPlayers = in.nextInt();
        in.nextLine();
        Player[] players = new Player[numbOfPlayers];
        int[] allegiance = new int[numbOfPlayers];
        char label;
        String playerName;

        System.out.println("Very well. Now please, for every player enter (1), if it will be a real person, or (0), if it will be a highly advanced AI");
        System.out.println("Then enter a character that will mark their turn, and lastly - the name under which they will be known on the battlefield. Do all of it in one string for each player(ex. 0 X PlayerOne):");
        for (int i = 0; i < numbOfPlayers; i++) {
            playerName = in.nextLine();
            allegiance[i] = Character.getNumericValue(playerName.charAt(0));
            label = playerName.charAt(2);
            playerName = playerName.substring(4);

            if (allegiance[i] == 0) {
                players[i] = new RandomGenPlayer(label, playerName);
            } else {
                players[i] = new RealLifePlayer(label, playerName);
            }
        }

        System.out.println("Now enter the length and the width of the battlefield:");
        int x = in.nextInt();
        in.nextLine();
        int y = in.nextInt();
        in.nextLine();

        System.out.println("And finally, what would be your win conditions?");
        WinConditions win = new WinConditions(in.nextInt());
        in.nextLine();
        System.out.println("Now then, lets begin!");

        TurnCoordinates currentCoordinates = new TurnCoordinates(0, 0);
        int turnCounter = 0;
        int currPlayerNumber;

        char[][] duhField =
                new char[x][y];

        Field f = new Field(x, y, duhField);
        f.initialize();
        duhField[0][0] = '`';
        Game newGame = new Game(x, y, players, f);

        while (!win.met(currentCoordinates, newGame.getDeck(), true)) {
            System.out.println("Currently, the desk looks like this:");
            System.out.println(newGame.getDeck());
            currPlayerNumber = turnCounter % numbOfPlayers;
            while (!newGame.getDeck().canTurn(currentCoordinates)) {
                if (allegiance[currPlayerNumber] == 1) {
                    currentCoordinates = players[currPlayerNumber].gettingATurn();
                    if (!newGame.getDeck().canTurn(currentCoordinates)) {
                        System.out.println("Sorry, but this spot is already filled by someone. Try one more time:");
                    }
                } else {
                    currentCoordinates = players[currPlayerNumber].gettingATurn(x, y);
                    System.out.println(currentCoordinates);
                }

            }

            newGame.createATurn(currentCoordinates, players[currPlayerNumber]);
            turnCounter++;
        }

        if (win.met(currentCoordinates, newGame.getDeck(), false)) {

            System.out.println("And now, ladies and gentlemen, we have a winner!");
            turnCounter--;
            System.out.println("Turn:" + turnCounter);
            System.out.println("The desk:");
            System.out.println(newGame.getDeck());
            System.out.println("The winning player:");
            System.out.println(players[turnCounter % numbOfPlayers].getPlayerName());

            System.out.println("Congratulations to the " + players[turnCounter % numbOfPlayers].getPlayerName() + "!");

        } else {
            System.out.println("Unfortunately, it seems this battle ends with a draw");
        }
    }


    public String theArtificialIdiots(int numberOfGames) {

        Double winRateForX = 0.0;
        Double winRateForO = 0.0;
        Double draws = 0.0;
        for (int i = 0; i != numberOfGames; i++) {
            WinConditions win = new WinConditions(3);
            char[][] duhField =
                    new char[3][3];

            TurnCoordinates currentCoordinates = new TurnCoordinates(0, 0);
            int turnCounter = 0;
            int CurrPlayerNumber;

            Field f = new Field(3, 3, duhField);
            f.initialize();
            duhField[0][0] = '`';
            RandomGenPlayer PlayerX = new RandomGenPlayer('X', "PlayerX");
            RandomGenPlayer PlayerO = new RandomGenPlayer('O', "PlayerO");
            Player[] players = {PlayerX, PlayerO};
            Game newGame = new Game(3, 3, players, f);
            while (!win.met(currentCoordinates, newGame.getDeck(), true)) {
                CurrPlayerNumber = turnCounter % 2;
                while (!newGame.getDeck().canTurn(currentCoordinates)) {
                    currentCoordinates = players[CurrPlayerNumber].gettingATurn(3, 3);
                }

                newGame.createATurn(currentCoordinates, players[CurrPlayerNumber]);
                turnCounter++;
            }

            if (win.met(currentCoordinates, newGame.getDeck(), false)) {

                if (players[turnCounter % 2] == PlayerX) {
                    winRateForX++;
                } else {
                    winRateForO++;
                }

            } else {
                draws++;
            }
        }
        winRateForX = (winRateForX / numberOfGames) * 100;
        winRateForO = (winRateForO / numberOfGames) * 100;
        draws = (draws / numberOfGames) * 100;
        return ("The percentage of wins of the first player against the second is " + winRateForX.toString() + ", the other way around - " + winRateForO.toString() + ", with the percentage of draws being " + draws.toString());

    }
}
