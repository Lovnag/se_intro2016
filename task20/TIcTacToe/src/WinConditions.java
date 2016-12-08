/**
 * Created by thy humble Lovnag on 19.11.2016.
 */
public class WinConditions {
    private int numberToWin;

    public WinConditions(int numberToWin) {
        this.numberToWin = numberToWin;
    }

    public int getNumberToWin() {
        return numberToWin;
    }

    public boolean met(TurnCoordinates a, Field deck, boolean indicator) {
        int x = a.getX();
        int y = a.getY();
        int sizX = deck.getSizeX();
        int sizY = deck.getSizeY();
        char[][] theDeck = deck.getDuhField();
        char label = theDeck[x][y];
        int kol = 0;
        for (int i = 0; i < sizX; i++) {
            if (theDeck[i][y] == label) {
                kol++;
            } else {
                kol = 0;
            }
            if (kol == numberToWin) {
                return true;
            }
        }

        kol = 0;

        for (int i = 0; i < sizY; i++) {
            if (theDeck[x][i] == label) {
                kol++;
            } else {
                kol = 0;
            }
            if (kol == numberToWin) {
                return true;
            }
        }

        int curX = x;
        int curY = y;
        while ((theDeck[curX][curY] == label) && (curX >= 0) && (curX < sizX - 1) && (curY >= 0) && (curY < sizY - 1)) {
            curX++;
            curY++;
        }

            if (theDeck[curX][curY] != label) {
                curX--;
                curY--;
            }

        kol = 0;
        while (theDeck[curX][curY] == label) {
            kol++;
            if (kol == numberToWin) {
                return true;
            }
            if ((curX > 0) && (curY > 0)) {
                curX--;
                curY--;
            } else {
                break;
            }

        }

        curX = x;
        curY = y;
        while ((theDeck[curX][curY] == label) && (curX > 0) && (curX <= sizX-1) && (curY >= 0) && (curY < sizY - 1)) {
            curX--;
            curY++;
        }
        if (theDeck[curX][curY] != label) {
            curX++;
            curY--;
        }
        kol = 0;
        while (theDeck[curX][curY] == label) {
            kol++;
            if (kol == numberToWin) {
                return true;
            }
            if ((curX < sizX-1) && (curY > 0)) {
                curX++;
                curY--;
            } else {
                break;
            }
        }

        if (indicator) {
        for (int i = 0; i < sizX; i++) {
            for (int j = 0; j < sizY; j++) {
                if ((theDeck[i][j] == ' ') || (theDeck[i][j] == '`')) {
                    return false;
                }
            }
        }
        return true;
        } else {
            return false;
        }
    }
}
