/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author miyan
 */
public class MouseInput extends MouseAdapter{
    
    private static final int NUM_BUTTONS = 10; 
    private boolean[] buttons;
    private boolean[] lastButtons;

    public MouseInput(){
        buttons = new boolean[NUM_BUTTONS];
        lastButtons = new boolean[NUM_BUTTONS];
    }
    
    public void update(){
        for (int i = 0; i < NUM_BUTTONS; i++) {
            lastButtons[i] = buttons[i];
        }
    }
    
    public boolean isDown(int button){
        return buttons[button];
        
        
    }
    
    public boolean wasPressed(int button){
        return isDown(button) && !lastButtons[button];
    }
    
    public boolean wasReleased(int button){
        return !isDown(button)&& lastButtons[button];
    }


    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }
    
}
