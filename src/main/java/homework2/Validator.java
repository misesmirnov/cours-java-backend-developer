package homework2;

public class Validator {

    private final String[] part;

    public Validator(String[] part) {
        this.part = part;
    }

    public String[] getExpression() {
        return part;
    }

    public boolean isValidateExpression() {
        boolean valid = false;
        // проверяем кол-во операторов в выражении
        if (part.length != 3) {
            getErrorMessage("Предайте выражение в формате а + b");
            return false;
        }
        //проверяем a
        if (!isOperandValid(part[0])) {
            getErrorMessage("Некорректный формат числа  а " + part[0]);
            return false;
        }
        //проверяем b
        if (!isOperandValid(part[2])) {
            getErrorMessage("Некорректный формат числа  b " + part[2]);
            return false;
        }
        // проверяем оператор
        if (!isOperatorValid(part[1])) {
            getErrorMessage("Неподдерживаемый тип операции " + part[0]);
        }
        return true;
    }

    private boolean isOperandValid(String operand) {
        try {
            Double.parseDouble(operand);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isOperatorValid(String operator) {
        for (Operator type : Operator.values()) {
            if (type.getOperator().equals(operator)) {
                return true;
            }
        }
        return false;
    }

    private void getErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

}
