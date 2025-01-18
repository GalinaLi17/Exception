package ExceptionPassword;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException () {
        super("Неправильный логин!");
    }
    public WrongLoginException(String message) {
        super(message);
    }
}
