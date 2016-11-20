import java.util.Scanner;

/**
 * Created by thy humble Lovnag on 20.11.2016.
 */
public class RunningTheGame {

    public RunningTheGame() {
    }

    public static String Run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Greetings, dear GameMaster. Dear GameMaster, please enter the number of players:");
        int numbOfPlayers = in.nextInt();
        in.nextLine();
        Player[] players = new Player[numbOfPlayers];
        int[] allegiance = new int[numbOfPlayers];
        char lable;
        String playerName;
        System.out.println("Very well. Now please, for every player enter (1), if it will be a real person, or (0), if it will be a highly advanced AI");
        System.out.println("Then enter a character that will mark their turn, and lastly - the name under which they will be known on the battlefield:");
        for (int i = 0; i < numbOfPlayers; i++) {
            playerName = in.nextLine();
            allegiance[i] = Character.getNumericValue(playerName.charAt(0));
            lable = playerName.charAt(2);
            playerName = playerName.substring(4);

            playerName = playerName.substring(2, playerName.length());
            if (allegiance[i] == 0) {
                players[i] = new RandomGenPlayer(lable, playerName);
            } else {
                players[i] = new RealLifePlayer(lable, playerName);
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

        TurnCoordinates CurrentCoordinates = new TurnCoordinates(0, 0);
        int turnCounter = 0;
        int CurrPlayerNumber;

        Game newGame = new Game(x, y, players);
        while (!win.Met(CurrentCoordinates, newGame.getDeck())) {
            System.out.println("Currently, the desk looks like this:");
            System.out.println(newGame.getDeck());
            CurrPlayerNumber = turnCounter % numbOfPlayers;
            while (!newGame.getDeck().canTurn(CurrentCoordinates)) {
                if (allegiance[CurrPlayerNumber] == 1) {
                    CurrentCoordinates = players[CurrPlayerNumber].gettingATurn();
                } else {
                    CurrentCoordinates = players[CurrPlayerNumber].gettingATurn(x, y);
                    System.out.println(CurrentCoordinates);
                }

                if (!newGame.getDeck().canTurn(CurrentCoordinates)) {
                    System.out.println("Sorry, but this spot is already filled by someone. Try one more time:");
                }
            }

            newGame.createATurn(CurrentCoordinates, players[CurrPlayerNumber]);
            turnCounter++;
        }
        System.out.println("And now, ladies and gentlemen, we have a winner!");
        turnCounter--;
        System.out.println("Turn:" + turnCounter);
        System.out.println("The desk:");
        System.out.println(newGame.getDeck());
        System.out.println("The winning player:");
        System.out.println(players[turnCounter % numbOfPlayers].getPlayerName());

        return "Congratulations to the " + players[turnCounter % numbOfPlayers].getPlayerName() + "!";

    }
}
