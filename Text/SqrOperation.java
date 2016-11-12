public class SqrOperation extends UnaryOperation {

    public SqrOperation(Expression value) {
        super(value);
    }

    protected double doCalculate(Expression expr) {
        double v = value.calculate();
        return v * v;
    }

    public String toString() {
        return "(" + "(" + value.toString() + ")" + "^2" + ")";
    }
}
