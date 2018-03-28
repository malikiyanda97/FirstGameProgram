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
import Survivor.states.State;
import Survivor.states.StateController;
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
    
    
//    private StateController sc
    private State menuState;
    private State pauseState;
    private State gameState;
    
    

    public Keyboard(EntityHandler EH, GameHandler GH){
        this.EH = EH;
        this.GH = GH;
       
    }    
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        //ENTITIES ITERATOR
        for (int i = 0; i < EH.entities.size(); i++) {
            Entities tempEntity = EH.entities.get(i);
            
            //PLAYER MOVEMENT
            if(tempEntity.getId() == Enums.Survivor){           
                if(key == KeyEvent.VK_W) EH.setUp(true);
                if(key == KeyEvent.VK_A) EH.setLeft(true);
                if(key == KeyEvent.VK_S) EH.setDown(true);        
                if(key == KeyEvent.VK_D) EH.setRight(true);

                //BULLETS 
                int x = (int) ((int) tempEntity.getX()+ 55);
                int y = (int) ((int) tempEntity.getY()+ 25);   
                if(key == KeyEvent.VK_SPACE) 
                    GH.getGameEH().addEntity(new Bullet(Enums.Bulllet, x, y, GH));
            }
     
        }
        //GAMESTATE KEYBOARD ACTIONS
        if(GH.getSC().getCurrentState().getId() == Enums.gameState){
            if(key == KeyEvent.VK_P) GH.getSC().setPause(true);
        }        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        //ENTITIES ITERATOR 
        for (int i = 0; i < EH.entities.size(); i++) {
            Entities tempEntity = EH.entities.get(i);
            
            //PLAYER MOVEMENT 
            if(tempEntity.getId() == Enums.Survivor){
                if(key == KeyEvent.VK_W) EH.setUp(false);
                if(key == KeyEvent.VK_A) EH.setLeft(false);
                if(key == KeyEvent.VK_S) EH.setDown(false);        
                if(key == KeyEvent.VK_D) EH.setRight(false);
            }
        }
        

        //GAMESTATE KEYBOARD ACTIONS
        if(GH.getGameState() == GH.getSC().getCurrentState()){
            if(key == KeyEvent.VK_P) GH.getSC().setPause(false);
        }
            
        
        
        
        
        
        //MENU OPTIONS INPUT 
        
//        MenuState state = GH.getGame().getMenuState();
//        if(StateManager.getState().getId() == Enums.menuState){  
//            if(key == KeyEvent.VK_W) menuState.setW(false);
//            if(key == KeyEvent.VK_UP) menuState.setUp(false);
//            if(key == KeyEvent.VK_DOWN) menuState.setDown(false);
//            if(key == KeyEvent.VK_S) menuState.setS(false);
//           
//            if(key == KeyEvent.VK_ENTER) menuState.setKeyClick(false);
//        }
        
   
    }

    
}
