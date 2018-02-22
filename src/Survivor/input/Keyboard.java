/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.input;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.EntityHandler;
import Survivor.entitiesManager.ID;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



/**
 *
 * @author miyan
 */

public class Keyboard extends KeyAdapter {

   
    public boolean shoot;
    
    private EntityHandler EH;
    
    public Keyboard(EntityHandler EH){
        this.EH = EH;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < EH.entities.size(); i++) {
            Entities tempEntity = EH.entities.get(i);
            
            if(tempEntity.getId() == ID.Player){
                if(key == KeyEvent.VK_W) EH.setUp(true);
                if(key == KeyEvent.VK_A) EH.setLeft(true);
                if(key == KeyEvent.VK_S) EH.setDown(true);        
                if(key == KeyEvent.VK_D) EH.setRight(true);
            }
     
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < EH.entities.size(); i++) {
            Entities tempEntity = EH.entities.get(i);
            
            if(tempEntity.getId() == ID.Player){
                if(key == KeyEvent.VK_W) EH.setUp(false);
                if(key == KeyEvent.VK_A) EH.setLeft(false);
                if(key == KeyEvent.VK_S) EH.setDown(false);        
                if(key == KeyEvent.VK_D) EH.setRight(false);
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