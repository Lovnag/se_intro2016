public class SqrtOperation extends UnaryOperation {

    public SqrtOperation(Expression value) {
        super(value);
    }

    protected double doCalculate(Expression expr) {
        return (sqrt(expr));
    }

    public static float sqrt(float a) {
        return B_sqrt(a, a);
    }

    public static float B_sqrt(float a, float p) {
        if (abs(a - p * p) > 0.00000000001) {
            return B_sqrt(a, (p + a / p) / 2);
        } else {
            return p;
        }
    }

    public static float abs(float a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    public String toString() {
        return "(" + "(" + value.toString() + ")" + "^0.5" + ")";
    }
}