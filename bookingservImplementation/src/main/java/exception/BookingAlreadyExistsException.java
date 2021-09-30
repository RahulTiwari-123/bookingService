package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.ALREADY_REPORTED, reason="Booking exists already")
public class BookingAlreadyExistsException extends RuntimeException{

    private Integer id;

    public BookingAlreadyExistsException(Integer id){
        this.id = id;
    }

}