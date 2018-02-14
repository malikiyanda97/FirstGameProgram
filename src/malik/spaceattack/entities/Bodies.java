/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.entities;

import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public abstract class Bodies extends Entity {
    
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_VELOCITY = 3.0f;   
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;
    
    protected float xAxis, yAxis;
    
    protected float velocity;
    protected int health;

    public Bodies(float x, float y, int width, int height) {
        super(x, y, width, height);
        health = DEFAULT_HEALTH;
        velocity = DEFAULT_VELOCITY;
        
        xAxis =0;
        yAxis =0;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
    }
    
    public void move(){
        x += xAxis;
        y += yAxis;
    }
    
    
    
    
    //GETTERS AND SETTERS 
    
    public float getxAxis() {
        return xAxis;
    }

    public void setxAxis(float xAxis) {
        this.xAxis = xAxis;
    }

    public float getyAxis() {
        return yAxis;
    }

    public void setyAxis(float yAxis) {
        this.yAxis = yAxis;
    }
    
    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
}
