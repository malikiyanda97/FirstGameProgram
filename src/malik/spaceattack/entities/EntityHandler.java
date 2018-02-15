/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.entities;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author miyan
 */
public class EntityHandler {
    
    private boolean up=false,
                    down = false,
                    right = false,
                    left = false; 


    public LinkedList<Entity> entities = new LinkedList<Entity>();
    

    
    public void update(){
        for(int i = 0; i < entities.size(); i++){
            Entity tempEntity = entities.get(i);
            
            tempEntity.update();
            
        }
            
    }
    
    public void render(Graphics g){
        for(int i = 0; i < entities.size(); i++){
            Entity tempEntity = entities.get(i);
            
            tempEntity.render(g);
            
        }        
    }
    
    
    public void addEntity(Entity tempEntity){
        entities.add(tempEntity);
    }
    
    public void removeEntity(Entity tempEntity){
        entities.remove(tempEntity);
    }
    
    //GETTERS AND SETTERS 
    public boolean isUp() {
            return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
    
    
    
    
    
    
}
