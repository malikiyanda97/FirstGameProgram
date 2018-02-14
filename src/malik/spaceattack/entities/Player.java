 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.entities;

import java.awt.Graphics;
import malik.spaceattack.Game;
import malik.spaceattack.spritesheets.PlayerSprite;

/**
 *
 * @author miyan
 */
public class Player extends Bodies {
    
    private Game game; 
    
    public Player(Game game, float x, float y) {
        super(x, y, 32, 64);
        this.game = game;
    }

    
    @Override
    public void update(){
        getInput();
        move();
    }
    
    private void getInput(){
        xAxis = 0;
        yAxis = 0;
        
        if(game.getKeyInput().up)
            yAxis = -velocity;
        if(game.getKeyInput().down)
            yAxis = velocity;
        if(game.getKeyInput().right)
            xAxis = velocity;
        if(game.getKeyInput().left)
            xAxis = -velocity;


    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(PlayerSprite.nudePlayer, (int) x, (int) y, width, height, null);
    }
    
    
    
}
