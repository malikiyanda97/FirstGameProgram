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
    
    private Animation aminR;
    private Animation aminL;
    private Animation aminU;
    private Animation aminD;   
    
    private BufferedImage lastImage = Images.playerDown[0];
    
    public Survivor(Enums ID, int x, int y, GameHandler GH, EntityHandler EH) {
        super(ID, x, y, GH);
        this.x = x;
        this.y = y;
        this.EH = EH;
        this.GH = GH;
  
        //ANIMATIONS
        aminD = new Animation(300, Images.playerDown);
        aminU = new Animation(300, Images.playerUp);
        aminR = new Animation(300, Images.playerRight);
        aminL = new Animation(300, Images.playerLeft);


    }

    @Override
    public void update() {
        x += velX;
        y += velY;
        
        collision();
        
        getInput();  
        
        aminD.update();
        aminU.update();
        aminR.update();
        aminL.update();
        
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(getLiveAnim(), (int)x, (int)y, null);

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
    
public BufferedImage getLiveAnim(){
        if(EH.isMoving()){
            switch (EH.getPlayerDirection()) {
            case 4:
                System.out.println("facing left = 4");
                lastImage = aminL.getCurrentFrame();
                return aminL.getCurrentFrame();
            case 2:
                System.out.println("facing right = 2");
                lastImage = aminR.getCurrentFrame();
                return aminR.getCurrentFrame();
            case 1:
                System.out.println("facing up = 1");
                lastImage = aminU.getCurrentFrame();
                return aminU.getCurrentFrame();
            case 3:
                System.out.println("facing down = 3");
                lastImage = aminD.getCurrentFrame();
                return aminD.getCurrentFrame();
            default:
                return lastImage;
        }
        }
        return lastImage;

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

    //GETTERS AND SETTERS 
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
