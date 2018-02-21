/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public class GameState extends StateManager {
    
    public GameState(){
        
    }

    
    
    
    
    @Override
    public void update() {
       
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, 1000, 800);
    }
    
}
