package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid request body")
public class InvalidRequestException extends RuntimeException{
    private String message;
    public InvalidRequestException(String message){
        super(message);
        this.message = message;
    }
}
