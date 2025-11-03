package homework2;

public class InvalidFormatException extends ValidationException {
    public InvalidFormatException() {
        super("Передайте выражение в формате: а + b");
    }
}
