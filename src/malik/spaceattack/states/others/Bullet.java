/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.states.others;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import malik.spaceattack.Game;
import malik.spaceattack.spritesheets.SpriteSheets;

/**
 *
 * @author miyan
 */
public class Bullet{
    
    private BufferedImage image;
    private Game game;
 
    private double x;
    private double y;
    
    public Bullet(Game game, double x, double y) {
        this.x = x;
        this.y = y;
        this.game = game;
        
        
        image = SpriteSheets.fireball;
    }
   
    
    public void update(){
        y -= 3;
    }
    
    
    public void render(Graphics g) {
        g.drawImage(image,(int) x, (int) y, null);
    }
    
    
    
    
}
