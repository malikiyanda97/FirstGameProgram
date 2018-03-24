/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

import Survivor.entitiesManager.EntityHandler;
import Survivor.states.GameState;

/**
 *
 * @author miyan
 */
public class GameHandler {
    
    private Game game;
    private GameState gameState;

    public GameHandler(Game game, GameState gameState){
        this.game = game;  
        this.gameState = gameState;
    }

    
    //Getters and Setters 
    
    public EntityHandler getGameEH(){
        return game.getEH();
    }
     
    public Game getGame() {
        return game;
    }    


    
}
