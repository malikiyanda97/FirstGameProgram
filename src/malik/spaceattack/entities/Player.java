 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.entities;

import java.awt.Graphics;
import malik.spaceattack.Game;
import static malik.spaceattack.entities.Controller.addBullet;
import malik.spaceattack.spritesheets.SpriteSheets;

/**
 *
 * @author miyan
 */
public class Player extends Bodies {
    
    private Game game; 
    private Controller c;
    
    public Player(Game game, float x, float y) {
        super(x, y, 32, 64);
        this.game = game;
        
        c = new Controller(game);
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
        else if(game.getKeyInput().down)
            yAxis = velocity;
        else if(game.getKeyInput().right)
            xAxis = velocity;
        else if(game.getKeyInput().left)
            xAxis = -velocity;
        else if(game.getKeyInput().shoot)
            Controller.addBullet(new Bullet(game, (int) x, (int) y));
            


//addBullet(new Bullet(game, 32, 64));
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(SpriteSheets.nudePlayer, (int) x, (int) y, width, height, null);
    }
    
    
    
}
