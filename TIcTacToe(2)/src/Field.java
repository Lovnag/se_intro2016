import static java.lang.String.valueOf;

/**
 * Created by Lovnag on 19.11.2016.
 */

public class Field {
    private int sizeX, sizeY;
    private char[][] duhField;

    public Field(int sizeX, int sizeY, char[][] duhField) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.duhField = duhField;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }


    public char[][] getDuhField() {
        return duhField;
    }

    public boolean canTurn(TurnCoordinates a) {
        return (duhField[a.getX()][a.getY()] == ' ')||(duhField[a.getX()][a.getY()] == '`');
    }

    public void makeATurn(TurnCoordinates a, char label) {
        if (canTurn(a)) {
            duhField[a.getX()][a.getY()] = label;
        }
    }

    public void initialize() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeX; j++) {
                duhField[i][j] = ' ';
            }
        }
    }

    public String toString() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.print(valueOf(duhField[i][j]) + ' ');
            }
            System.out.println();
        }
        return " ";
    }
}
