import static java.lang.String.valueOf;

/**
 * Created by Lovnag on 19.11.2016.
 */

public class Field {
    private int sizeX, sizeY;

    public Field(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        for (int i = 0; i != sizeX; i++) {
            for (int j = 0; j != sizeX; j++) {
                duhField[i][j] = ' ';
            }
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    private char[][] duhField =
            new char[sizeX][sizeY];

    public char[][] getDuhField() {
        return duhField;
    }

    public boolean canTurn(TurnCoordinates a) {
        return duhField[a.getX()][a.getY()] == ' ';
    }

    public void makeATurn(TurnCoordinates a, char label) {
        if (canTurn(a)) {
            duhField[a.getX()][a.getY()] = label;
        }
    }

    public String toString() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.print(valueOf(duhField[i][j]) + ' ');
            }
            System.out.println();
        }

        return null;
    }
}
