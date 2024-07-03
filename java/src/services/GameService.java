package services;

import exceptions.InvalidMoveException;
import models.Board;
import models.Game;
import models.Player;
import models.Status;

import java.util.Objects;
import java.util.Scanner;

public class GameService {
    Game game;
    BoardService boardService;

    String player1SuccessStatus = "XXX";
    String player2SuccessStatus = "OOO";

    public GameService(Player player1, Player player2){
        this.boardService = new BoardService();
        this.game = createGame(player1, player2);
    }

    public Game createGame(Player player1, Player player2){

        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        Board board = boardService.createBoard();
        return new Game(board, players);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        System.out.println("Game has started....");
        while(true){

            try{
                System.out.print("Enter the move (type 'exit' to quit): ");
                input = scanner.nextLine();

                if(input.equals("exit")){
                    break;
                }

                String[] positions = input.split(" ");

                int rowPosition = Integer.parseInt(positions[0])-1;
                int colPosition = Integer.parseInt(positions[1])-1;

                makeTheMove(rowPosition, colPosition);
            } catch (Exception e) {
                System.out.println("Move is invalid - " + input + " because " + e.getMessage());
            }
            boardService.printBoard(game.getBoard());

            String gameStatus = getGameStatus();
            if(Objects.nonNull(gameStatus)){
                System.out.println(gameStatus);
                break;
            }
        }
    }

    private String getGameStatus() {
        Board board = game.getBoard();
        boolean flag = true;
        for(int i=0;i<board.getROWS();i++){
            String currStatus = "";
            for (int j=0;j<board.getCOLUMNS();j++){
                if(board.getCells()[i][j].getStatus().equals(Status.EMPTY)){
                    flag = false;
                }
                if(Objects.nonNull(board.getCells()[i][j].getSymbol())){
                    currStatus += board.getCells()[i][j].getSymbol().getSymbolString();
                }
                else{
                    currStatus +=  "-";
                }

            }

            if(currStatus.equals(player1SuccessStatus)){
                return game.getPlayers()[0].getName() + " has won the game.";
            }

            if(currStatus.equals(player2SuccessStatus)){
                return game.getPlayers()[1].getName() + " has won the game.";
            }
        }

        if(flag){
            return "Game Over and game is draw";
        }

        for(int i=0;i<board.getROWS();i++){
            String currStatus = "";
            for (int j=0;j<board.getCOLUMNS();j++){
                if(Objects.nonNull(board.getCells()[j][i].getSymbol())){
                    currStatus += board.getCells()[j][i].getSymbol().getSymbolString();
                }
                else{
                    currStatus +=  "-";
                }

            }

            if(currStatus.equals(player1SuccessStatus)){
                return game.getPlayers()[0].getName() + " has won the game.";
            }

            if(currStatus.equals(player2SuccessStatus)){
                return game.getPlayers()[1].getName() + " has won the game.";
            }
        }

        String currStatus = "";

        for(int i=0;i<board.getROWS();i++){
            if(Objects.nonNull(board.getCells()[i][i].getSymbol())){
                currStatus += board.getCells()[i][i].getSymbol().getSymbolString();
            }
            else{
                currStatus +=  "-";
            }
        }

        if(currStatus.equals(player1SuccessStatus)){
            return game.getPlayers()[0].getName() + " has won the game.";
        }

        if(currStatus.equals(player2SuccessStatus)){
            return game.getPlayers()[1].getName() + " has won the game.";
        }

        currStatus = "";

        for(int i=0;i<board.getROWS();i++){
            if(Objects.nonNull(board.getCells()[i][board.getCOLUMNS()-i-1].getSymbol())){
                currStatus += board.getCells()[i][board.getCOLUMNS()-i-1].getSymbol().getSymbolString();
            }
            else{
                currStatus +=  "-";
            }
        }

        if(currStatus.equals(player1SuccessStatus)){
            return game.getPlayers()[0].getName() + " has won the game.";
        }

        if(currStatus.equals(player2SuccessStatus)){
            return game.getPlayers()[1].getName() + " has won the game.";
        }

        return null;
    }

    private void makeTheMove(int rowPosition, int colPosition) throws InvalidMoveException {
        if(!game.getBoard().getCells()[rowPosition][colPosition].getStatus().equals(Status.EMPTY)){
            throw new InvalidMoveException("Position is already occupied");
        }

        game.getBoard().getCells()[rowPosition][colPosition].setSymbol(game.getPlayers()[game.getCurrentTurn()].getSymbolChoose());
        game.getBoard().getCells()[rowPosition][colPosition].setStatus(Status.OCCUPIED);
        game.setCurrentTurn(1- game.getCurrentTurn());
    }
}
