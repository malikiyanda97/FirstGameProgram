/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.entities;

import java.awt.Graphics;
import java.util.LinkedList;
import malik.spaceattack.Game;

/**
 *
 * @author miyan
 */
public class Controller {
    
    private static LinkedList<Bullet> b = new LinkedList<Bullet>();
    
    Game game ;
    Bullet tempBullet;
    
    public Controller(Game game){
        this.game = game;
        
    }
    
    
    public void update(){
        for (int i = 0; i < b.size(); i++){
            tempBullet = b.get(i);
            tempBullet.update();
            
        }
    }
   
    public void render(Graphics g){
        for (int i = 0; i < b.size(); i++){
            tempBullet = b.get(i);
            tempBullet.render(g);
            
        }        
    }
    
    public static void addBullet(Bullet bullet){
        b.add(bullet);        
    }
    
    public static void removeBullet(Bullet bullet){
        b.remove(bullet);
    }
    
}
