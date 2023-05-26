package pl.aleksanderinglot.rentalservice.exceptions;

public class LessorNotFoundException extends RuntimeException {
    public LessorNotFoundException(String message) {
        super(message);
    }

    public LessorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LessorNotFoundException(Throwable cause) {
        super(cause);
    }
}
