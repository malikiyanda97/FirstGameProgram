/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack;

import malik.spaceattack.entities.Entity;

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
    
    public void tick(Entity entity){
        x += ((entity.getX() -x ) -  1110/2)*0.05f;
        x += ((entity.getY() -y ) -  800/2)*0.05f;
        
        if(x <= 0 ) x = 0;
        if(x >= 1032) x = 1032;
        if(y <= 0) y = 0;
        if(y >= 800) y = 800;
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
