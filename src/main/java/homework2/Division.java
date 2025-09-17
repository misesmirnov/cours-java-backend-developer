package homework2;

public class Division extends Operation {

    public Division(double a, double b) {
        super(a, b);
    }

    @Override
    public double getOperationResult() {
        if (b == 0) {
            System.out.println("Деление на ноль");
            return Double.NaN;
        }
        return a / b;
    }
}
