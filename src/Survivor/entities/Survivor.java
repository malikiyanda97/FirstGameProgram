/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.EntityHandler;
import Survivor.entitiesManager.ID;
import Survivor.images.Images;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class Survivor extends Entities {

    private EntityHandler EH;
    private GameHandler GH;
    
    
    public Survivor(ID ID, int x, int y, GameHandler GH, EntityHandler EH) {
        super(ID, x, y, GH);
        
        this.EH = EH;
        this.GH = GH;
        
    }
    
    public int getSurviorX(){
        return x;
    }
    
    public int getSurvivorY(){
        return y;
    }

    @Override
    public void update() {
        x += velX;
        y += velY;
        
        collision();
        
        getInput();        
        
    }
    
    private void collision(){
        for (int i = 0; i < GH.getGameEH().entities.size(); i++) {
            
            Entities tempObject = GH.getGameEH().entities.get(i);
            
            if(tempObject.getId() == ID.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    x += velX * -1;
                    y += velY *  -1;
                }
            }   
         }   
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.nakedPlayer, x, y, null);
       
    }

    @Override
    public Rectangle getBounds() { //like around the character
        return new Rectangle(x, y, 32, 48);
    }
    
    private void getInput(){
        
        //Movement Actions
        if(EH.isDown()) velY = 5;
        else if(!EH.isUp()) velY = 0;
        
        if(EH.isUp()) velY = -5;
        else if(!EH.isDown()) velY = 0;
        
        if(EH.isRight()) velX = 5;
        else if(!EH.isLeft()) velX = 0;
        
        if(EH.isLeft()) velX = -5;
        else if(!EH.isRight()) velX = 0;         
    
    }
    
    
}

