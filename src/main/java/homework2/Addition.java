package homework2;

public class Addition extends Operation {

    public Addition(double a, double b) {
        super(a, b);
    }

    @Override
    public double getOperationResult() {
        return a + b;
    }
}
