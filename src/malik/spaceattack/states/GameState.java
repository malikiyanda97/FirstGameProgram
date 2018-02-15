/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.states;

import java.awt.Graphics;
import malik.spaceattack.Game;
import malik.spaceattack.entities.Controller;
import malik.spaceattack.entities.Player;
import malik.spaceattack.spritesheets.SpriteSheets;

/**
 *
 * @author miyan
 */
public class GameState extends StateManager {
    
    
    private Player player;
    private Controller c;
    
    public GameState(Game game){
        super(game);
        player = new Player(game, 100,100);
        c = new Controller(game);
        
    }

    @Override
    public void Update(){
        player.update();
        c.update();
    }

    @Override
    public void Render(Graphics g) {
        player.render(g);
        c.render(g);

    }
    
}
