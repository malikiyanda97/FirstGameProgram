/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entitiesManager;

import Survivor.Enums;
import Survivor.GameHandler;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public abstract class Entities {
   
    protected int x, y;
    protected int velX = 0, velY = 0;
    protected boolean alive;
    protected boolean dead;
    
    protected Enums ID;
    protected GameHandler GH;

    public Entities(Enums id, int x, int y, GameHandler GH){
        this.x = x;
        this.y = y;
        this.ID = id;
        this.GH = GH;
        
        
    }

    
    
    public abstract void collision();
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

    public Enums getId() {
        return ID;
    }

    public void setId(Enums id) {
        this.ID = id;
    }
    
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    
    
}
