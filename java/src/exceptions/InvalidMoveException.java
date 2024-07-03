package exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class InvalidMoveException extends Exception{
    public InvalidMoveException(String message){
        super(message);
    }
}
