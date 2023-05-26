package pl.aleksanderinglot.rentalservice.exceptions;

public class ReservationAlreadyExistsException extends RuntimeException {
    public ReservationAlreadyExistsException(String message) {
        super(message);
    }

    public ReservationAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
