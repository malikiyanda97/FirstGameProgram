/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

import static Survivor.Enums.pauseState;
import Survivor.entitiesManager.EntityHandler;
import Survivor.input.Keyboard;
import Survivor.states.GameState;
import Survivor.states.MenuState;
import Survivor.states.PauseState;
import Survivor.states.StateController;

/**
 *
 * @author miyan
 */
public class GameHandler {
    
    public Game game;
    private GameState gameState;
    private MenuState menuState;
    private PauseState pauseState;

    public GameHandler(Game game, GameState gameState, MenuState menuState, PauseState pauseState){
        this.game = game;  
        this.gameState = gameState;
        this.menuState = menuState;
        this.pauseState = pauseState;
    }

    
    //GETTERS AND SETTERS 
    public EntityHandler getGameEH(){
        return game.getEH();
    }
     
    public Game getGame() {
        return game;
    }    
    
    public Keyboard getKeyboard(){
        return game.keyboard;
    }
    
    public StateController getSC(){
        return game.sc;
    }
    
    public GameState getGameState(){
        return game.gameState;
    }
    
    public PauseState getPauseState(){
        return game.pauseState;
    }    

    public MenuState getMenuState(){
        return game.menuState;
    }

    
}
