package exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameCreationException extends Exception{
    public GameCreationException(String message){
        super(message);
    }
}
