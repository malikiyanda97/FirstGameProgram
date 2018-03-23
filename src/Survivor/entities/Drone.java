/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.Enums;
import Survivor.images.Images;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import static java.lang.Math.sqrt;

/**
 *
 * @author miyan
 */
public class Drone extends Entities {
    
    int health = 100;
    int speed = 2;
    
    
    private float playerX;
    private float playerY;
    
    private int x, y;    
    
    public Drone(Enums id, int x, int y, GameHandler GH) {
        super(id, x, y, GH);
        
        this.x = x;
        this.y = y;
    }
//        System.out.println("player "+ playerX + " , " + playerY);
    @Override
    public void update() {

        for (int i = 0; i < GH.getGameEH().entities.size(); i++) {
            Entities tempEnttity = GH.getGameEH().entities.get(i);
            
            if(tempEnttity.getId() == ID.Survivor){
                 float targetX = tempEnttity.getX();
                 float targetY = tempEnttity.getY();
                 
                 float dirX = targetX - x;
                 float dirY = targetY - y;
       
                 float hypotenuse = (float) sqrt((dirX * dirX) + (dirY * dirY));

                 if(hypotenuse != 0){
                    y += speed*(dirY/hypotenuse);
                    x += speed*(dirX/hypotenuse);
                }
            }
            
        }

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
                    GH.getGameEH().removeEntity(tempEntity);
                    health -= 50;
                    
                }
            }    
            if(tempEntity.getId() == ID.Enemy){
                if(getBounds().intersects(tempEntity.getBounds())){
                    //todo : if enemies collide
                }
                
                
            }            
        }        
        
    }
    
    public void AdvanceWalkPhase(){
//        int targetX = 1024;
//        int targetY = 480;
//        
//        float dirX = targetX - x;
//        float dirY = targetY - y;
//       
//        float hypotenuse = (float) sqrt((dirX * dirX) + (dirY * dirY));
//
//        if(hypotenuse != 0){
//            y += speed*(dirY/hypotenuse);
//            x += speed*(dirX/hypotenuse);
//        }

        int a = (int) (playerX - x);
        int b = (int)(playerY - y);

        double h = (int)Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
            
        int moveX = (int) (a/h *speed);
        int moveY = (int) (b/h *speed);
        
        x = x+moveX;
        y = y+moveY;
    }    
}
