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

/**
 *
 * @author miyan
 */
public class Bullet extends Entities {

    private int bulletSpeed = 20;
    private int x, y;
    private int FACING;


    
    public Bullet(Enums id, int x, int y, GameHandler GH){
        super(id, x, y, GH);
        
        this.x = x;
        this.y = y;
        
        velX = x /bulletSpeed;
        velY = y /bulletSpeed;
   
        if(GH.getGameEH().getPlayerDirection() == 1)
            FACING = 1;
        if(GH.getGameEH().getPlayerDirection() == 2)
            FACING = 2;
        if(GH.getGameEH().getPlayerDirection() == 3)
            FACING = 3;
        if(GH.getGameEH().getPlayerDirection() == 4)
            FACING = 4;
    }   
    
  
    @Override
    public void update(){   
        if(FACING == 1){
            y-=10;
        }
        if(FACING == 2){
            x+=10;
        }     
        if(FACING == 3){
            y+=10;
        }   
        if(FACING == 4){
            x-=10;
        }        
        
        collision();
        
    }

    @Override
    public void collision() {
        for (int i = 0; i < GH.getGameEH().entities.size(); i++) {
            Entities tempEntity = GH.getGameEH().entities.get(i);
           
            if(tempEntity.getId() == ID.Wall){
                if(getBounds().intersects(tempEntity.getBounds())){
                    //System.out.println("wall in the way of bullet");
                    GH.getGameEH().removeEntity(this);
                }
                    
                
           }
            
            
        }
            }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, 8, 8);
        
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.red);
        g2d.draw(getBounds());
        
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,8,8);
    }
    
}
