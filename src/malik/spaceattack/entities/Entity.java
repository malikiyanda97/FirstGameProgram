/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public abstract class Entity {
    
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_VELOCITY = 3.0f;   
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;
    
    protected int x, y;
    protected int velX = 0, velY = 0;
    //protected int width, height;
    protected ID id;
    
    
    public Entity(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
//        this.width = DEFAULT_CREATURE_WIDTH;
//        this.height = DEFAULT_CREATURE_HEIGHT;
        
        
    }

    
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    
    //GETTERS AND SETTERS 

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
    
    
    
    
}
