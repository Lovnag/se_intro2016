/**
 * Created by thy humble Lovnag on 19.11.2016.
 */
public interface Player {

    char getLabel();

    String getPlayerName();

    TurnCoordinates gettingATurn();

    TurnCoordinates gettingATurn(int x, int y);

}
