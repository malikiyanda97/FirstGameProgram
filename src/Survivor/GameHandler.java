/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

import Survivor.entitiesManager.EntityHandler;
import Survivor.input.Mouse;

/**
 *
 * @author miyan
 */
public class GameHandler {
    
    private Game game;

    public GameHandler(Game game){
        this.game = game;  
    }

    
    //Getters and Setters 
    
    public EntityHandler getGameEH(){
        return game.getEH();
    }
    
    public Mouse getMouse(){
        return game.getMouse();
    }
    
    

    public void setGame(Game game) {
        this.game = game;
    }
    
    public Game getGame() {
        return game;
    }    
    
}
