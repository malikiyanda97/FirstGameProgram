/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.ID;
import Survivor.images.Images;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class Wall extends Entities {

    public Wall(ID id, int x, int y, GameHandler GH) {
        super(id, x, y, GH);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(x, y, 32, 32);
        g.drawImage(Images.walls, x, y, null);
        
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        
        
//        g2d.draw(getBounds());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }

    @Override
    public void collision() {
    }
    
}
