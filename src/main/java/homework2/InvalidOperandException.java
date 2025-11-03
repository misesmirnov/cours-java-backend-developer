package homework2;

public class InvalidOperandException extends ValidationException {
    public InvalidOperandException(String operand, String value) {
        super(String.format("Некорректный формат числа %s: %s", value, operand));
    }
}
