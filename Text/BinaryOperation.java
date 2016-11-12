public abstract class BinaryOperation implements Expression {
    private Expression value1;
    private Expression value2;

    public BinaryOperation(Expression value1, Expression value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public double calculate() {
        return doCalculate(value);
    }

    protected abstract double doCalculate(Expression expr);
}
