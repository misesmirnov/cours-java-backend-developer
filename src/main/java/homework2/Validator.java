package homework2;

public class Validator {

    private final String[] part;

    public Validator(String[] part) {
        this.part = part;
    }

    public void validateExpression() throws ValidationException {
        if (part == null) {
            throw new ValidationException("Выражение не может быть null");
        }
        // проверяем кол-во операторов в выражении
        if (part.length != 3) {
            throw new InvalidFormatException();
        }
        //проверяем a
        validateOperand(part[0], "a");
        //проверяем b
        validateOperand(part[2], "b");
        // проверяем оператор
        validateOperator(part[1]);
    }

    private void validateOperand(String operand, String value) throws InvalidOperandException {
        if (operand == null) {
            throw new InvalidOperandException(operand, "Пустое число");
        }
        try {
            Double.parseDouble(operand);
        } catch (NumberFormatException e) {
            throw new InvalidOperandException(operand, value);
        }
    }

    private void validateOperator(String operator) throws InvalidOperatorException {
        boolean valid = false;
        for (Operator type : Operator.values()) {
            if (type.getOperator().equals(operator)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new InvalidOperatorException(operator);
        }
    }
}
