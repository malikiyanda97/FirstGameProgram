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
import java.util.Random;

/**
 *
 * @author miyan
 */
public class Enemy extends Entities {
    
    Random r = new Random();
    int choose = 0; 
    int hp = 100;
    
    public Enemy(ID id, int x, int y, GameHandler GH) {
        super(id, x, y, GH);
    }

    @Override
    public void update() {
        x+= velX;
        y+= velY;
        
        choose = r.nextInt(10);
        
        for (int i = 0; i < GH.getGameEH().entities.size(); i++) {
            Entities tempEntity = GH.getGameEH().entities.get(i);
            
            //WALL BOUNCING 
            if(tempEntity.getId() == ID.Wall){
                if(getBigBounds().intersects(tempEntity.getBounds())){
                 x += (velX*5) * -1;
                 y += (velY*5) * -1;
                }else if (choose == 0){
                    velX = (r.nextInt(4- -4) + -4);
                    velY = (r.nextInt(4- -4) + -4);
                }
            }
                          
            //ENEMY DESTROYING 
            if(tempEntity.getId() == ID.Bulllet){
                if(getBounds().intersects(tempEntity.getBounds())){
                    hp -= 50;
                    GH.getGameEH().entities.remove(tempEntity);
                }
            }            
        }
        
        if(hp <=0){
            GH.getGameEH().entities.remove(this);
        }
        

    
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }

    public Rectangle getBigBounds() {
        return new Rectangle(x-16,y-16,32,32);
    }    
}
