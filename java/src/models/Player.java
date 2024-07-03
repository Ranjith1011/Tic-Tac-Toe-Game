package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private Symbol symbolChoose;

    public Player(String name, String symbolChoose) throws Exception {
        this.name = name;
        this.symbolChoose = Symbol.getSymbol(symbolChoose);
    }
}
