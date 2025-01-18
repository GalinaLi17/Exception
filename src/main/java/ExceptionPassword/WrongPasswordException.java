package ExceptionPassword;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        super("Неправильный пароль!");
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}
