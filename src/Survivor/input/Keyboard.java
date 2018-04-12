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
import Survivor.entities.Survivor;
import Survivor.states.State;
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
    private Survivor S;
    
    private int x, y;
    
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
                if(key == KeyEvent.VK_W){
                    EH.setMoving(true);
                    EH.setPlayerDirection(1);
                    EH.setUp(true);
                }
                if(key == KeyEvent.VK_A){
                 EH.setMoving(true);
                    EH.setPlayerDirection(4);
                    EH.setLeft(true);
                }
                if(key == KeyEvent.VK_S){
                    EH.setMoving(true);
                    EH.setPlayerDirection(3);
                    EH.setDown(true);
                }        
                if(key == KeyEvent.VK_D){
                    EH.setMoving(true);
                    EH.setPlayerDirection(2);
                    EH.setRight(true);
                }

                //BULLETS 
            switch (EH.playerDirection){
            case 1:
                x = (int) ((int) tempEntity.getX()+25);
                y = (int) ((int) tempEntity.getY()); 
                break;
            case 2:
                x = (int) ((int) tempEntity.getX()+55);
                y = (int) ((int) tempEntity.getY()+25);
                break;
            case 3:
                x = (int) ((int) tempEntity.getX()+25);
                y = (int) ((int) tempEntity.getY()+55);
                break;
            case 4:
                x = (int) ((int) tempEntity.getX()+25);
                y = (int) ((int) tempEntity.getY()+25);
                break;
       }
                
                if(EH.getPlayerDirection() == 4 && key == KeyEvent.VK_SPACE){ 
                    GH.getGameEH().addEntity(new Bullet(Enums.Bulllet, x, y, GH));                
                }
                
                if(EH.getPlayerDirection() == 1 && key == KeyEvent.VK_SPACE){
                    GH.getGameEH().addEntity(new Bullet(Enums.Bulllet, x, y, GH));                
                }
                if(EH.getPlayerDirection() == 2 && key == KeyEvent.VK_SPACE){
                    GH.getGameEH().addEntity(new Bullet(Enums.Bulllet, x, y, GH));                
                }
                if(EH.getPlayerDirection() == 3 && key == KeyEvent.VK_SPACE){
                    GH.getGameEH().addEntity(new Bullet(Enums.Bulllet, x, y, GH));                
                }                
                
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
                if(key == KeyEvent.VK_W){
                    EH.setMoving(false);
                    EH.setUp(false);
                }
                if(key == KeyEvent.VK_A){
                    EH.setMoving(false);
                    EH.setLeft(false);
                }
                if(key == KeyEvent.VK_S){
                    EH.setMoving(false);
                    EH.setDown(false);
                }        
                if(key == KeyEvent.VK_D){
                    EH.setMoving(false);
                    EH.setRight(false);
                }
                if(key == KeyEvent.VK_SPACE){
                    
                }
            }
        }
        

        //GAMESTATE KEYBOARD ACTIONS
        if(GH.getGameState() == GH.getSC().getCurrentState()){
            if(key == KeyEvent.VK_P) GH.getSC().setPause(false);
        }
            
        
       
    }

    
}
