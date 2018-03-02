/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.ID;
import Survivor.images.Images;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class Drone extends Entities {
    
    int health = 200;
    
    public Drone(ID id, int x, int y, GameHandler GH) {
        super(id, x, y, GH);
    }

    @Override
    public void update() {
        x += velX ;
        y += velY;
       
        collision();
  
        
        if(health <= 0){
            GH.getGameEH().removeEntity(this);
        }
 }

    @Override
    public void render(Graphics g) {
        
        g.drawImage(Images.droneEnemy, x, y, null);
//        g.setColor(Color.YELLOW);
//        g.fillRect(x, y, 32, 32);

        
        g.setColor(Color.red);
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(getBounds());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x+5,y,48,50);
    }  

    @Override
    public void collision() {
        for (int i = 0; i < GH.getGameEH().entities.size(); i++) {
            Entities tempEntity = GH.getGameEH().entities.get(i);
            
                          
            //ENEMY DESTROYING 
            if(tempEntity.getId() == ID.Bulllet){
                if(getBounds().intersects(tempEntity.getBounds())){
                    health -= 50;
//                    GH.getGameEH().removeEntity(this);
                }
            }            
        }        
        
    }
}
