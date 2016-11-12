public class Value implements Expression {
    private double value;

    public Value(double value) {
        this.value = value;
    }

    public double calculate() {
        return this.value;
    }

    public String toString() {
        return "(" + value.toString() + ")";
    }
}
