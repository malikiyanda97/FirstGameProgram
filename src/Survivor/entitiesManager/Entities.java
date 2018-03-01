/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entitiesManager;

import Survivor.GameHandler;
import Survivor.images.Sheets;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public abstract class Entities {
   
    protected int x, y;
    protected int velX = 0, velY = 0;
    protected ID ID;
    protected GameHandler GH;
    
    public Entities(ID id, int x, int y, GameHandler GH){
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

    public ID getId() {
        return ID;
    }

    public void setId(ID id) {
        this.ID = id;
    }
    
    
    
}
