package pl.aleksanderinglot.rentalservice.exceptions;

public class LesseeNotFoundException extends RuntimeException {
    public LesseeNotFoundException(String message) {
        super(message);
    }

    public LesseeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LesseeNotFoundException(Throwable cause) {
        super(cause);
    }
}
