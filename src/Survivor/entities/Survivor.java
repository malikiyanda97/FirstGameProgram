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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
   

    @Override
    public void update() {
        x += velX;
        y += velY;
        
        collision();
        
        getInput();        
        
    }
    
    @Override
    public void collision(){
        for (int i = 0; i < GH.getGameEH().entities.size(); i++) {
            
            Entities tempEntity = GH.getGameEH().entities.get(i);
            
            if(tempEntity.getId() == ID.Wall){
                if(getBounds().intersects(tempEntity.getBounds())){
                    System.out.println("wall in the way");
                    x += velX * -1;
                    y += velY *  -1;
                }
            }
            
            
            if(tempEntity.getId() == ID.Wall){
                if(getBounds().intersects(tempEntity.getBounds())){
                    System.out.println("Enemy in the way");
                }
            }
         }   
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.nakedPlayer, x, y, null);
        System.out.println("player co-ords "+ x + " , " + y);
        
        
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
        g2d.draw(getBounds());
       
    }

    @Override
    public Rectangle getBounds() { // around the character
        return new Rectangle(x+5, y+5, 25, 52)  ;
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
    
    


