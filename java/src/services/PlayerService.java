package services;

import exceptions.PlayerCreationException;
import models.Player;

public class PlayerService {

    public Player createPlayer(String playerDetails) throws PlayerCreationException {
        try{
            String[] playerDetailsInfo = playerDetails.split(" ");
            return new Player(playerDetailsInfo[1], playerDetailsInfo[0]);
        } catch (Exception e) {
            throw new PlayerCreationException("Player Creation Failed: " + e.getMessage());
        }

    }
}
