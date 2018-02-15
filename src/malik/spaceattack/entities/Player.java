 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import malik.spaceattack.spritesheets.SpriteSheets;

/**
 *
 * @author miyan
 */
public class Player extends Entity {
    
    private EntityHandler handler; 
    
    public Player(int x, int y, ID id, EntityHandler handler) {
        super(x, y, id);
        this.handler = handler;
        
    }

    
    @Override
    public void update(){
        x += velX;
        y += velY;
        
        getInput();
        
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(SpriteSheets.nudePlayer, (int)x, (int)y, null);
//        g.setColor(Color.blue);
//        g.fillRect(x, y, 32, 48);
    
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
    
    private void getInput(){
        
        //Moving
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

