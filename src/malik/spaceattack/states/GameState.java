/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.states;

import java.awt.Graphics;
import malik.spaceattack.Game;
import malik.spaceattack.entities.Player;

/**
 *
 * @author miyan
 */
public class GameState extends StateManager {
    
    
    private Player player;
    
    public GameState(Game game){
        super(game);
        player = new Player(game, 100,100);
        
    }

    @Override
    public void Update(){
        player.update();
    }

    @Override
    public void Render(Graphics g) {
        player.render(g);
        //g.drawImage(WorldSprite.grass, 0, 0, null);
       // g.drawImage(WorldSprite.stone, 100, 100, null);
    }
    
}
