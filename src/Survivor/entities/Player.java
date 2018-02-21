/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.EntityEnums;
import Survivor.entitiesManager.EntityHandler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class Player extends Entities {

    private EntityHandler handler; 

    public Player(int x, int y, EntityEnums id, EntityHandler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void update() {
        x += velX;
        y += velY;
        
        getInput();        
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 48);        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
    
    private void getInput(){
        
        //Movement Actions
        if(handler.isDown()) velY = 5;
        else if(!handler.isUp()) velY = 0;
      
        if(handler.isUp()) velY = -5;
        else if(!handler.isDown()) velY = 0;
        
        if(handler.isRight()) velX = 5;
        else if(!handler.isLeft()) velX = 0;
        
        if(handler.isLeft()) velX = -5;
        else if(!handler.isRight()) velX = 0;         
        
       
    }
    
}
