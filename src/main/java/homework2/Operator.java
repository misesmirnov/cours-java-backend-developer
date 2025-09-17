package homework2;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String operator;

    Operator(String operation) {
        this.operator = operation;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator fromOperation(String operator) {
        for (Operator type : values()) {
            if (type.operator.equals(operator)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Неизвестный оператор " + operator);
    }
}
