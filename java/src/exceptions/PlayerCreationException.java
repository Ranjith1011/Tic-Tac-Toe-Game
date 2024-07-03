package exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayerCreationException extends Exception{
    public PlayerCreationException(String message){
        super(message);
    }
}
