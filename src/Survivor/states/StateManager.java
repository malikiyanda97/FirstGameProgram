/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public abstract class StateManager {
    
 
    
    
    public StateManager(){
        
    }
    
    
    private static StateManager currentState = null;
    
    
    
    
    public static void setState(StateManager state){
        currentState = state;
    }
    
    public static StateManager getState(){
        return currentState;
    }
    
    
    
    public abstract void update();
    public abstract void render(Graphics g);
    
}
