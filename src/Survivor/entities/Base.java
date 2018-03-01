/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.ID;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class Base extends Entities {

    private int baseStrength = 100;
    
    public Base(ID id, int x, int y, GameHandler GH) {
        super(id, x, y, GH);
    }

    @Override
    public void update() {
        
        
       //Base Destroying 
        for (int i = 0; i < GH.getGameEH().entities.size(); i++) {
            Entities tempEntity = GH.getGameEH().entities.get(i);
            
            if(tempEntity.getId() == ID.Enemy){
                if(getBounds().intersects(tempEntity.getBounds())){
                    baseStrength -= 25;
                }
            }
        }
        
        if(baseStrength <= 0){
            GH.getGameEH().entities.remove(this);
        }
     
        
        
        
        
        
        
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 64, 64);
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,64,64);
    }

    @Override
    public void collision() {
    }
    
}
