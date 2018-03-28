/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.EntityHandler;
import Survivor.Enums;
import Survivor.images.Animation;
import Survivor.images.Images;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author miyan
 */
public class Survivor extends Entities {

    private EntityHandler EH;
    private GameHandler GH;
    
    public float x;
    public float y;
    
    private Animation playerRight;
    private Animation playerLeft;
    private Animation playerUp;
    private Animation playerDown;    
    
    public Survivor(Enums ID, int x, int y, GameHandler GH, EntityHandler EH) {
        super(ID, x, y, GH);
        this.x = x;
        this.y = y;
        this.EH = EH;
        this.GH = GH;
    
        playerUp = new Animation(15, Images.tu1, Images.tu2, Images.tu3, Images.tu4, Images.tu5, Images.tu6, Images.tu7);
        playerDown = new Animation(15, Images.td1, Images.td2, Images.td3, Images.td4, Images.td5, Images.td6, Images.td7);    
        playerLeft = new Animation(15, Images.tl1, Images.tl2, Images.tl3, Images.tl4, Images.tl5, Images.tl6, Images.tl7);
        playerRight = new Animation(15, Images.tr1, Images.tr2, Images.tr3, Images.tr4, Images.tr5, Images.tr6, Images.tr7);
        
    }

   

    @Override
    public void update() {
        x += velX;
        y += velY;
        
        collision();
        
        getInput();   
        
        playerRight.runAnimation(); 
        playerLeft.runAnimation();         
        playerUp.runAnimation(); 
        playerDown.runAnimation();
        
    }
   

    @Override
    public void render(Graphics g) {
        
        //g.drawImage(Images.tr7, (int)x, (int)y, null);
        drawPlayerAnimations(g);
        //HEALTH BAR
        g.drawImage(Images.healthB,(int) x+10, (int) y-12, null);
        g.drawImage(Images.healthPlayer,(int) x+10,(int) y-12, null);
        g.drawImage(Images.healthBoarder, (int) x+10,(int) y-12, null);
        System.out.println("player co-ords "+ x + " , " + y);
        
        
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
        g2d.draw(getBounds());
       
    }
 
    @Override
    public Rectangle getBounds() { // around the character
        return new Rectangle((int)(x), (int)(y), 64, 64)  ;
    }
    
//    public BufferedImage drawIdleImage(BufferedImage image){
//       if(EH.isDown()){
//            g.draw
//        }
//         if(EH.isUp()){
//             //g.drawImage(TODO: UP IDLE);
//            playerUp.drawAnimation(g, (int)x, (int)y);
//        }        
//         if(EH.isRight()){
//             //g.drawImage(TODO: DOWN IDLE);
//            playerRight.drawAnimation(g, (int)x, (int)y);
//        }        
//         if(EH.isLeft()){
//             //g.drawImage(TODO: DOWN IDLE);
//            playerLeft.drawAnimation(g, (int)x, (int)y);
//                
//    }
    
    public void drawPlayerAnimations(Graphics g){       
        //DRAW ANIMATION
         if(EH.isDown()){
             //g.drawImage(TODO: DOWN IDLE);
            playerDown.drawAnimation(g, (int)x, (int)y);
        }
         if(EH.isUp()){
             //g.drawImage(TODO: UP IDLE);
            playerUp.drawAnimation(g, (int)x, (int)y);
        }        
         if(EH.isRight()){
             //g.drawImage(TODO: DOWN IDLE);
            playerRight.drawAnimation(g, (int)x, (int)y);
        }        
         if(EH.isLeft()){
             //g.drawImage(TODO: DOWN IDLE);
            playerLeft.drawAnimation(g, (int)x, (int)y);
        }        
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
    
    private void getInput(){
        //MOVE
        if(EH.isDown() && EH.isRight()) EH.setRight(false);
        if(EH.isDown() && EH.isLeft()) EH.setLeft(false);
        
        if(EH.isUp() && EH.isLeft()) EH.setLeft(false);
        if(EH.isUp() && EH.isRight()) EH.setRight(false);
        
        if(EH.isDown()) velY = 3;
        else if(!EH.isUp()) velY = 0;
        
        if(EH.isUp()) velY = -3;
        else if(!EH.isDown()) velY = 0;
        
        if(EH.isRight()) velX = 3;
        else if(!EH.isLeft()) velX = 0;
        
        if(EH.isLeft()) velX = -3;
        else if(!EH.isRight()) velX = 0;  
        

        }
//getters and setters

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }    
    

}


        //DON'T DRAW ANIMATION
//        if(EH.isDown() && EH.isRight()) 
//            g.drawImage(Images.td1,(int)x, (int)y, null);
//            //playerDown.drawAnimation(g, (int)x, (int)y);
//        if(EH.isDown()&& EH.isLeft())
//            playerDown.drawAnimation(g, (int)x, (int)y);
//
//        if(EH.isUp() && EH.isRight())
//            playerUp.drawAnimation(g, (int)x, (int)y);          
//        if(EH.isUp() && EH.isLeft())
//            playerUp.drawAnimation(g, (int)x, (int)y); 
    
    


