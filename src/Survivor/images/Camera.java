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
    
    public void update(Entities entity){
        x += ((entity.getX() -x ) -  1200/2)*0.05f;
        y += ((entity.getY() -y ) -  800/2)*0.05f;
        
        
        //LOCK CAMERA
        if(x <= 0 ) x = 0;
        if(x >= 1200) x = 1200+30;
        if(y <= 0) y = 0;
        if(y >= 800+16) y = 800+16;
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
