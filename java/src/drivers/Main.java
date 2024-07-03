package drivers;

import models.Player;
import services.GameService;
import services.PlayerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        PlayerService playerService = new PlayerService();
        Scanner scanner = new Scanner(System.in);
        String line;

        try{
            System.out.println("Enter player details in format - \"symbol name\" - Eg: X Ranjith");
            System.out.print("Enter player-1 details : ");
            line = scanner.nextLine();
            Player player1 = playerService.createPlayer(line);

            System.out.print("Enter player-2 details : ");
            line = scanner.nextLine();
            Player player2 = playerService.createPlayer(line);

            GameService gameService = new GameService(player1, player2);

            gameService.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
