package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Board {
    int ROWS = 3;
    int COLUMNS = 3;

    Cell[][] cells;

    public Board(){
        this.cells = new Cell[ROWS][COLUMNS];

        for(int i=0;i<ROWS;i++){
            for (int j=0;j<COLUMNS;j++){
                this.cells[i][j] = new Cell();
            }
        }
    }
}
