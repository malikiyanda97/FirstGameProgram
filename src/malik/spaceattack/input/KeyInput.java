/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author miyan
 */

public class KeyInput extends KeyAdapter {

    
    private boolean[] keys;
    public boolean up, down, left, right;
    
    public KeyInput(){
        keys = new boolean[256];
    }
    
    public void update(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        right = keys[KeyEvent.VK_RIGHT];
        left = keys[KeyEvent.VK_LEFT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]= true;
        System.out.println("pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
    public boolean isKeyDown(int keycode){
        return keys[keycode];
    }
    
}
