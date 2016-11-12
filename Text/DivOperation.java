public class DivOperation extends BinaryOperation {

    public DivOperation(Expression value1, Expression value2) {
        super(value1, value2);
    }

    protected double doCalculate(Expression expr1, Expression expr2) {
        return expr1 / expr2;
    }

    public String toString() {
        return "(" + value1.toString() + "/" + value2.toString() + ")";
    }
}