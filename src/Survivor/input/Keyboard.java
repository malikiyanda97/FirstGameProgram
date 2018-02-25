/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.input;

import Survivor.GameHandler;
import Survivor.entities.Bullet;
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
    private GameHandler GH;
    
    public Keyboard(EntityHandler EH, GameHandler GH){
        this.EH = EH;
        this.GH = GH;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < EH.entities.size(); i++) {
            Entities tempEntity = EH.entities.get(i);
            
            //right shooting
             int x = (int) tempEntity.getX() + 18;
             int y = (int) tempEntity.getY() + 20;
              
            //left shooting 
//             int x = (int) tempEntity.getX() + 18;
//             int y = (int) tempEntity.getY() + 20
             
            if(tempEntity.getId() == ID.Survivor){
                if(key == KeyEvent.VK_W) EH.setUp(true);
                if(key == KeyEvent.VK_A) EH.setLeft(true);
                if(key == KeyEvent.VK_S) EH.setDown(true);        
                if(key == KeyEvent.VK_D) EH.setRight(true);
                

                //                
//                
                //shoot
                if(key == KeyEvent.VK_SPACE) EH.addEntity(new Bullet(ID.Bulllet, x, y, GH));
//                if(key == KeyEvent.VK_SPACE && EH.isRight())
            }
     
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < EH.entities.size(); i++) {
            Entities tempEntity = EH.entities.get(i);
            
            if(tempEntity.getId() == ID.Survivor){
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