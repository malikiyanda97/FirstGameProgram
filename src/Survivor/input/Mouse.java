 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author miyan
 */
public class Mouse implements MouseListener, MouseMotionListener{

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    
    
    public Mouse(){
        
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() ==  MouseEvent.BUTTON1)
            leftPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() ==  MouseEvent.BUTTON1)
            leftPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    
    
    //GETTERS 
    public boolean isLeftPressed(){
        return leftPressed;
    }
    
    public boolean isRightPressed(){
        return rightPressed;
    }
    
    public int getXMouse(){
        return mouseX;
    }
    
    public int getYMouse(){
        return mouseY;
    }


    
}
