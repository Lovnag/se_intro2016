public class AbsOperation extends UnaryOperation {

    public AbsOperation(Expression value) {
        super(value);
    }

    protected double doCalculate(Expression expr) {
        if (expr > 0) {
            return expr;
        } else {
            return -expr;
        }
    }

    public String toString() {
        return "|" + value.toString() + "|";
    }
}
