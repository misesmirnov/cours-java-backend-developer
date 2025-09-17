package homework2;

public class Multiplication extends Operation {

    public Multiplication(double a, double b) {
        super(a, b);
    }

    @Override
    public double getOperationResult() {
        return a * b;
    }
}
