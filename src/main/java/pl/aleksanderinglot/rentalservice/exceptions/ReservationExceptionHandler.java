package pl.aleksanderinglot.rentalservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReservationExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(ReservationAlreadyExistsException reservationAlreadyExistsException) {
        ReservationErrorResponse reservationErrorResponse = new ReservationErrorResponse();
        reservationErrorResponse.setStatus(HttpStatus.CONFLICT.value());
        reservationErrorResponse.setMessage(reservationAlreadyExistsException.getMessage());
        reservationErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(reservationErrorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(LessorNotFoundException lessorNotFoundException) {
        ReservationErrorResponse reservationErrorResponse = new ReservationErrorResponse();

        reservationErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        reservationErrorResponse.setMessage(lessorNotFoundException.getMessage());
        reservationErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(reservationErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(LesseeNotFoundException lesseeNotFoundException) {
        ReservationErrorResponse reservationErrorResponse = new ReservationErrorResponse();

        reservationErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        reservationErrorResponse.setMessage(lesseeNotFoundException.getMessage());
        reservationErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(reservationErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(PlaceForRentNotFoundException placeForRentNotFoundException) {
        ReservationErrorResponse reservationErrorResponse = new ReservationErrorResponse();

        reservationErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        reservationErrorResponse.setMessage(placeForRentNotFoundException.getMessage());
        reservationErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(reservationErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(ReservationNotFoundException reservationNotFoundException) {
        ReservationErrorResponse reservationErrorResponse = new ReservationErrorResponse();

        reservationErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        reservationErrorResponse.setMessage(reservationNotFoundException.getMessage());
        reservationErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(reservationErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(Exception exception) {
        ReservationErrorResponse reservationErrorResponse = new ReservationErrorResponse();

        reservationErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        reservationErrorResponse.setMessage(exception.getMessage());
        reservationErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(reservationErrorResponse, HttpStatus.BAD_REQUEST);
    }
}