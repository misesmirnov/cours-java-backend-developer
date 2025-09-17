package homework2;

public class Parser {
    private final String expression;
    private String[] part;

    public Parser(String expression) {
        this.expression = expression;
        this.part = getPart();
    }

    public String getExpression() {
        return expression;
    }

    public String[] getPart() {
        return expression.split(" ");
    }

    public double getFirstOperand() {
        try {
            return Double.parseDouble(part[0]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public double getSecondOperand() {
        try {
            return Double.parseDouble(part[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public Operator getOperator() {
        return Operator.fromOperation(part[1]);
    }
}
