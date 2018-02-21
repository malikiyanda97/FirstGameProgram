/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.survivor.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import malik.survivor.entitiesManager.Entities;
import malik.survivor.entitiesManager.EntityEnums;
import malik.survivor.entitiesManager.EntityHandler;


/**
 *
 * @author miyan
 */

public class Keyboard extends KeyAdapter {

   
    public boolean shoot;
    
    EntityHandler handler;
    
    public Keyboard(EntityHandler handler){
        this.handler = handler;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.entities.size(); i++) {
            Entities tempEntity = handler.entities.get(i);
            
            if(tempEntity.getId() == EntityEnums.Player){
                if(key == KeyEvent.VK_W) handler.setUp(true);
                if(key == KeyEvent.VK_A) handler.setLeft(true);
                if(key == KeyEvent.VK_S) handler.setDown(true);        
                if(key == KeyEvent.VK_D) handler.setRight(true);
            }
     
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.entities.size(); i++) {
            Entities tempEntity = handler.entities.get(i);
            
            if(tempEntity.getId() == EntityEnums.Player){
                if(key == KeyEvent.VK_W) handler.setUp(false);
                if(key == KeyEvent.VK_A) handler.setLeft(false);
                if(key == KeyEvent.VK_S) handler.setDown(false);        
                if(key == KeyEvent.VK_D) handler.setRight(false);
            }
     
        }
    }
    

    
}













//    public Keyboard(){
//        keys = new boolean[256];
//    }
//    
//    public void update(){
//        up = keys[KeyEvent.VK_UP];
//        down = keys[KeyEvent.VK_DOWN];
//        right = keys[KeyEvent.VK_RIGHT];
//        left = keys[KeyEvent.VK_LEFT];
//        shoot = keys[KeyEvent.VK_SPACE];
//        
//    }