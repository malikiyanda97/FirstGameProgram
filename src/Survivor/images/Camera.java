package Survivor.images;

import Survivor.entitiesManager.Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author miyan
 */
public class Camera {
    
    private float x, y;
    
    public Camera(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public void update(Entities entities){
        x += ((entities.getX() -x ) -  1400/2)*0.05f;
        y += ((entities.getY() -y ) -  1000/2)*0.05f;
        
        
        //LOCK CAMERA
        if(x <= 0 ) x = 0;
        if(x >=650) x = 650;
        
        
        if(y <= 0) y = 0;
        if(y >= 50) y = 50;
        
    }
    
    
    //GETTERS AND SETTERS 

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    

    
}
