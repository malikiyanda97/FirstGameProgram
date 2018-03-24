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
import Survivor.Enums;
import Survivor.states.MenuState;
import Survivor.states.StateManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



/**
 *
 * @author miyan 
 *
 * */

public class Keyboard extends KeyAdapter{
    
    private GameHandler GH;
    private EntityHandler EH;
    private MenuState menuState;
    
    private int key;
    

    public Keyboard(int key, MenuState menuState, EntityHandler EH, GameHandler GH){
        this.menuState = menuState;
        this.EH = EH;
        this.GH = GH;
        this.key = key;
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        
        for (int i = 0; i < EH.entities.size(); i++) {
            Entities tempEntity = EH.entities.get(i);
     
            if(tempEntity.getId() == Enums.Survivor){           
                if(key == KeyEvent.VK_W) EH.setUp(true);
                if(key == KeyEvent.VK_A) EH.setLeft(true);
                if(key == KeyEvent.VK_S) EH.setDown(true);        
                if(key == KeyEvent.VK_D) EH.setRight(true);

                //bullets coming from player
                int x = (int) ((int) tempEntity.getX()+ 18);
                int y = (int) ((int) tempEntity.getY()+ 20);   
                if(key == KeyEvent.VK_SPACE) 
                    GH.getGameEH().addEntity(new Bullet(Enums.Bulllet, x, y, GH));
            }
     
        }
        
        if(StateManager.getState().getId() == Enums.menuState){
            MenuState state = GH.getGame().getMenuState();
            
            if(key == KeyEvent.VK_W) state.setW(true);
            if(key == KeyEvent.VK_UP) state.setUp(true);
            if(key == KeyEvent.VK_DOWN) state.setDown(true);
            if(key == KeyEvent.VK_S) state.setS(true);
            
            if(key == KeyEvent.VK_ENTER) state.setKeyClick(true);
        }
       

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < EH.entities.size(); i++) {
            Entities tempEntity = EH.entities.get(i);
            
            if(tempEntity.getId() == Enums.Survivor){
                if(key == KeyEvent.VK_W) EH.setUp(false);
                if(key == KeyEvent.VK_A) EH.setLeft(false);
                if(key == KeyEvent.VK_S) EH.setDown(false);        
                if(key == KeyEvent.VK_D) EH.setRight(false);
            }
     
        }
        
        if(StateManager.getState().getId() == Enums.menuState){
            MenuState state = GH.getGame().getMenuState();
            
            if(key == KeyEvent.VK_W) state.setW(false);
            if(key == KeyEvent.VK_UP) state.setUp(false);
            if(key == KeyEvent.VK_DOWN) state.setDown(false);
            if(key == KeyEvent.VK_S) state.setS(false);
            
            if(key == KeyEvent.VK_ENTER) state.setKeyClick(false);
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