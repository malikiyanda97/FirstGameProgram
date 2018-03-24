/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.GameHandler;
import Survivor.entitiesManager.EntityHandler;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public abstract class StateManager {
    
 
    protected GameHandler GH;
    protected EntityHandler EH;
    protected Enum id;
    
    
    public StateManager(Enum id, GameHandler GH){
        this.id = id;
        this.GH = GH;
    }
    
    
    
    private static StateManager currentState = null;
    
    
    
    
    public static void setState(StateManager state){
        currentState = state;
    }
    
    public static StateManager getState(){
        return currentState;
    }
    
    
    public abstract void init();
    public abstract void update();
    public abstract void render(Graphics g);
    



//Getters and setters 
    public Enum getId() {
        return id;
    }

    public void setId(Enum id) {
        this.id = id;
    }
    

}