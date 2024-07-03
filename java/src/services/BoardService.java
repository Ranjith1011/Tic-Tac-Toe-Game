package services;

import models.Board;

import java.util.Objects;

public class BoardService {
    public Board createBoard(){
        return new Board();
    }

    public void printBoard(Board board){
        System.out.println("Board Status:");
        for(int i = 0; i<board.getROWS();i++){
            String row = "";
            for (int j=0;j<board.getCOLUMNS();j++){
                if(Objects.nonNull(board.getCells()[i][j].getSymbol())){
                    row += board.getCells()[i][j].getSymbol().getSymbolString() + " ";
                }
                else{
                    row +=  "- ";
                }

            }
            System.out.println(row);
        }
    }

}
