/**
 * Created by Lovnag on 19.11.2016.
 */

public class Game {
    private int x, y;
    private Player players[];
    private Field deck;

    public Game(int x, int y, Player[] players, Field deck) {
        this.x = x;
        this.y = y;
        this.players = players;
        this.deck = deck;
    }

    public void initializing() {
        deck.initialize();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getDeck() {
        return deck;
    }

    public void createATurn(TurnCoordinates CurrentCoordinates, Player player) {
        deck.makeATurn(CurrentCoordinates, player.getLabel());
    }


}
