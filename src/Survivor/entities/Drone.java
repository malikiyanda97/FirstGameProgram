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
    
    private int startHealth;
    private int health;
    private int speed = 1;
    
    
    private float playerX;
    private float playerY;
    
    private int x, y; 
    private boolean alive;
    
    public Drone(Enums id, int x, int y, int health, GameHandler GH) {
        super(id, x, y, GH);
        
        this.health = 100;
        this.startHealth = health;  
        this.x = x;
        this.y = y;
    }

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
        float healthPercentage = health / startHealth;
        g.drawImage(Images.droneEnemy, x, y, null);
        g.drawImage(Images.healthB, x+10, y-12, null);
        g.drawImage(Images.healthEnemy, x+10, y-12, null);
        g.drawImage(Images.healthBoarder, x+10, y-12, null);
        
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
                    damage(50);         
                }
            }    
            if(tempEntity.getId() == ID.Enemy){
                if(getBounds().intersects(tempEntity.getBounds())){
                    //TODO: ENEMY COLLISION
                }
                
                
            }            
        }        
        
    }
    
    public void die(){
        alive = false;
    }

    private void damage(int amount) {
        health -= amount;
        if(health<0){
            die();
        }
    }
}  
