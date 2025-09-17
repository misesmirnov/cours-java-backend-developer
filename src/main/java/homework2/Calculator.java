package homework2;

public class Calculator {

    private final double a;
    private final double b;
    private final Operator operator;

    public Calculator(double a, double b, Operator operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public double calculate() {
        Operation operation = createOperation(a, b, operator);
        return operation.getOperationResult();
    }

    public Operation createOperation(double a, double b, Operator operator) {
        return switch (operator) {
            case PLUS -> new Addition(a, b);
            case MINUS -> new Subtraction(a, b);
            case MULTIPLICATION -> new Multiplication(a, b);
            case DIVISION -> new Division(a, b);
        };
    }
}
