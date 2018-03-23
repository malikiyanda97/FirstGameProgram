/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

import Survivor.entitiesManager.EntityHandler;
import Survivor.images.Camera;
import Survivor.input.Mouse;
import Survivor.menu.Menu;
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
    
    public Mouse getMouse(){
        return game.getMouse();
    }
     

    public void setGame(Game game) {
        this.game = game;
    }
    
    public Game getGame() {
        return game;
    }    
    
    public Menu getMenu(){
        return game.getMenu();
    }
    
}
