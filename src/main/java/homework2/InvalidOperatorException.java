package homework2;

public class InvalidOperatorException extends ValidationException {
    public InvalidOperatorException(String operator) {
        super(String.format("Некорректный тип операции: %s", operator));
    }
}
