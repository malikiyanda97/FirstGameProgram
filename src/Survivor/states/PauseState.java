/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.Enums;
import Survivor.GameHandler;
import Survivor.images.Images;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public class PauseState extends StateManager {
    
    private Enums id;
    
    public PauseState(Enums id, GameHandler GH) {
        super(id, GH);
        this.id = Enums.pauseState;
    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.menuWallpaper, 1400, 1000, null);
    }
    
}
