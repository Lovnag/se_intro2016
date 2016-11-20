/**
 * Created by Lovnag on 19.11.2016.
 */

import java.util.Scanner;

public class RealLifePlayer implements Player {
    private char label;
    private String playerName;

    public RealLifePlayer(char label, String playerName) {
        this.label = label;
        this.playerName = playerName;
    }

    public RealLifePlayer(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

    public String getPlayerName() {
        return playerName;
    }

    public TurnCoordinates gettingATurn(int x, int y) {
        return null;
    }

    public TurnCoordinates gettingATurn() {
        Scanner in = new Scanner(System.in);
        System.out.println("Dear " + playerName + ", please enter your turn:");
        int n = in.nextInt();
        in.nextLine();
        int k = in.nextInt();
        return new TurnCoordinates(n-1, k-1);

    }
}