/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.Enums;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import Survivor.images.Images;

/**
 *
 * @author miyan
 */
public class Base extends Entities {

    private int baseStrength = 100;
    
    public Base(Enums id, int x, int y, GameHandler GH) {
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
            System.out.println("game over");
        }
     
        
        
        
        
        
        
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.castleBase, x, y, null);
        System.out.println("base co-ords "+ x + " , " + y);
//        g.setColor(Color.green);
//        g.fillRect(x, y, 64*3, 64*3);
        
        
        g.setColor(Color.white);
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(getBounds());
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,Images.castleBase.getWidth(),Images.castleBase.getHeight());
    }

    @Override
    public void collision() {
    }
    
}
