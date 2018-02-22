/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.GameHandler;
import Survivor.entities.Player;
import Survivor.entitiesManager.EntityHandler;
import Survivor.entitiesManager.ID;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public class GameState extends StateManager {
    
    
    private Player player;
    private EntityHandler EH; //only for keyboard use 
    
    
    public GameState(GameHandler GH, EntityHandler EH){
        super(GH);
        this.EH = EH;
        init();   
    
    }
 
    @Override
    public void init(){
        GH.getGameEH().addEntity(new Player(100,100, ID.Player, GH, EH));
    }
    
    @Override
    public void update() {
        GH.getGameEH().update();

       
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, 1000, 800);
        
        GH.getGameEH().render(g);
        
    }
    
}
