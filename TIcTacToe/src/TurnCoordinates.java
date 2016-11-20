/**
 * Created by Lovnag on 19.11.2016.
 */
public class TurnCoordinates {
    private int x;
    private int y;

    public TurnCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return x + " " + y;
    }
}
