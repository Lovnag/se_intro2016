public class Main {
    public static void main(String[] args) {
        Expression a = new SumOperation(2, 3);
        Expression b = new Value(-10);
        Expression c = new SqrOperation(5);
        Expression d = new MulOperation(a, b);
        Expression e = new SumOperation(d, c);
        double k = e.calculate();
        System.out.println(e.toString() + "=" + k);
    }
}