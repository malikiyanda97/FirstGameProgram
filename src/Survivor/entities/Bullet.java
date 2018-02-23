/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.ID;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class Bullet extends Entities {

    public Bullet(ID id, int x, int y, GameHandler GH) {
        super(id, x, y, GH);
    }

    @Override
    public void update() {
        x+= velX;
        x+= velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, 8, 8);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(8, 8);
    }
    
}
