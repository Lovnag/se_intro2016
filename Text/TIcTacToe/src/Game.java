/**
 * Created by Lovnag on 19.11.2016.
 */

public class Game {
    private int x, y;
    private Player players[];

    public Game(int x, int y, Player[] players) {
        this.x = x;
        this.y = y;
        this.players = players;
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

    private Field deck = new Field(x, y);

    public Field getDeck() {
        return deck;
    }

    public void createATurn(TurnCoordinates CurrentCoordinates, Player player) {
        deck.makeATurn(CurrentCoordinates, player.getLabel());
    }


}
