/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

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
    public void setGame(Game game) {
        this.game = game;
    }
    
    public Game getGame() {
        return game;
    }    
    
}
