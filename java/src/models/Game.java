package models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Game {
    private String id;
    private Board board;
    Player[] players;

    private int currentTurn;

    public Game(Board board, Player[] players){
        this.board = board;
        this.players = players;
        this.id = UUID.randomUUID().toString();
        this.currentTurn = 0;
    }

}
