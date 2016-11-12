public abstract class UnaryOperation implements Expression {
    private Expression value;

    public UnaryOperation(Expression value) {
        this.value = value;
    }

    public double calculate() {
        return doCalculate(value);
    }

    protected abstract double doCalculate(Expression expr);
}
