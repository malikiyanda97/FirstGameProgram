/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.Game;
import Survivor.GameHandler;
import Survivor.images.Images;
import Survivor.input.Mouse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class MenuState extends StateManager {

    private Mouse mouse;
    
    private final String[] options = {"Play","Options","Exit"};
    
    public Rectangle singlePlayerButton = new Rectangle(1000/2 + 120,150,100,50);
    public Rectangle instructionsButton = new Rectangle(1000/2 + 120,250,100,50);
    public Rectangle exitButton = new Rectangle(1000/2 + 120,350,100,50);
    
    public MenuState(Mouse mouse, GameHandler GH){
        super(GH);
        this.mouse = mouse;
    }
    
    
    
    @Override
    public void init() {
    }    

    @Override
    public void update() {
        System.out.println(mouse.getXMouse() + "    " + mouse.getYMouse());
        if(mouse.isLeftPressed())
            StateManager.setState(GH.getGame().gameState);
               
//        if(mouse.isLeftPressed() && mouse.getXMouse() ){
//        if(mouse.getXMouse() >= 1400/2 + 120 && 
//           mouse.getYMouse() <= 1400/2 + ){
//                StateManager.setState(GH.getGame().gameState);
//        }
//    }
        

    
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 1400, 1000);
//        g.drawImage(Images.menuWallpaper, 1400, 1000, null);

        g.setColor(Color.red);
        g.fillRect(mouse.getXMouse(), mouse.getYMouse(), 8, 8);
    
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.ORANGE);
        g.drawString("SURVIVOR",1000/2, 100);



        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);    
        g.drawString("Play", singlePlayerButton.x+20, singlePlayerButton.y+35);
        g.drawString("Help", instructionsButton.x+20, instructionsButton.y+35);
        g.drawString("Exit", exitButton.x+20, exitButton.y+35);
        g2d.draw(singlePlayerButton);
        g2d.draw(instructionsButton);
        g2d.draw(exitButton);
        
        
    }


    
}
