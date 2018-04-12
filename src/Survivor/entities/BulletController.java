/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author miyan
 */
public class BulletController {
    
    private static ArrayList<Bullet> bulletList= new ArrayList<>();
    
    Bullet tempBullet;
    GameHandler GH;

    public BulletController(GameHandler GH) {
        this.GH = GH;
        
        
    }
    
    public void update(){
        for (int i = 0; i < bulletList.size(); i++) {
            tempBullet = bulletList.get(i);
            
            if(tempBullet.getY() < 0 )
                removeBullet(tempBullet);
            if(tempBullet.getY() > 1400 )
                removeBullet(tempBullet);
            if(tempBullet.getX() < 0 )
                removeBullet(tempBullet);            
            if(tempBullet.getX() < 1000 )
                removeBullet(tempBullet);        
            
            tempBullet.update();
        }
    }
    
    public void render(Graphics g){
        for (int i = 0; i < bulletList.size(); i++) {
            tempBullet = bulletList.get(i);        
            tempBullet.render(g);
        }
    } 

    public void addBullet(Bullet block){
        bulletList.add(block);
        
    }
    
    public void removeBullet(Bullet block){
        bulletList.remove(block);
    }
    
    public static ArrayList<Bullet> getBullet(){
        return bulletList;
    }

}

