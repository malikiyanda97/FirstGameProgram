/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.Enums;
import Survivor.GameHandler;
import Survivor.entitiesManager.EntityHandler;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public class gameOverState implements State {

    private EntityHandler EH;
    private Enums id;
    private GameHandler GH;
    
    
    public gameOverState(Enums id, GameHandler GH) {
        this.id = Enums.gameOver;
        this.GH = GH;   
        
    }
    
    

    @Override
    public void init() {
    }

    @Override
    public void enter() {
    }

    @Override
    public void update(StateController stateController) {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, GH.getGame().width, GH.getGame().width);
        
        g.setColor(Color.white);
        g.drawString("Game Over!", 600,600);
    
    }

    @Override
    public void exit() {
    }

    @Override
    public String getName() {
        return "gameOver";
    }

    @Override
    public Enums getId() {
        return id;
                
    }
    
}
