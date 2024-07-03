package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell {
    Symbol symbol;
    Status status;

    public Cell(){
        symbol = null;
        status = Status.EMPTY;
    }
}
