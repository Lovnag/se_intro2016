/**
 * /* Created by Lovnag on 19.11.2016.
 */

import java.util.Random;

public class RandomGenPlayer implements Player {
    private char label;
    private String playerName;

    public RandomGenPlayer(char label, String playerName) {
        this.label = label;
        this.playerName = playerName;
    }

    public char getLabel() {
        return label;
    }

    public String getPlayerName() {
        return playerName;
    }

    public TurnCoordinates gettingATurn() {
        return null;
    }

    public TurnCoordinates gettingATurn(int x, int y) {
        Random r = new Random();
        int n = r.nextInt(x) + 1;
        int k = r.nextInt(y) + 1;
        return new TurnCoordinates(n, k);

    }


}
