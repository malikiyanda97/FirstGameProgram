/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.Enums;
import Survivor.GameHandler;
import Survivor.images.Images;
import Survivor.input.Keyboard;
import Survivor.input.Mouse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class PauseState implements State {
    
    public Keyboard keyboard;
    public Mouse mouse;
    
    public GameButtons[] options;
    private GameHandler GH;
    private Enums id;
    private int selection=0;
    private int RENDERING_GAP = 70;
    
    
    
    public PauseState(Enums id,Mouse mouse, Keyboard keybaord, GameHandler GH) {
        this.GH = GH;
        this.id = Enums.pauseState;
        this.mouse = mouse; 
        this.keyboard = keyboard;
        
        
        options = new GameButtons[4];
           
        //MENU OPTION
        options[0] = new GameButtons("RESUME GAME", 100, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);
        options[1] = new GameButtons("UPGRAGES", 100+ 1*RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);          
        options[2] = new GameButtons("SAVE GAME", 100 + 2* RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);        
        options[3] = new GameButtons("RETURN TO MAIN MENU", 100+ 3*RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);      
        
    }

    @Override
    public void init() {
    }

    @Override
    public void update(StateController sc) {
        boolean clicked = false;
        for (int i = 0; i < options.length; i++) {
            if(options[i].intersects(new Rectangle(mouse.getX(), mouse.getY(), 2, 2))){
                selection = i;
                if(mouse.isLeftPressed())
                    clicked = true;
            }
        }
          
        if(clicked) 
            chooseOption();

        
    }
    
    public void chooseOption(){
        OUTER:
        while (selection < options.length) {
            switch (selection) {
                case 0:
                    System.out.println("RESUME GAME");
                    GH.getSC().setState("game");
                    break OUTER;
                case 1:
                    System.out.println("UPGRADES");
                    break OUTER;
                case 2:
                    System.out.println("SAVE GAME");
                    break OUTER;
                case 3:
                    System.out.println("RETURN TO MAIN MENU");
                    //TODO : Pop out to warn game wont be saved.
                    GH.getSC().setState("menu");
                    break OUTER;
                default:
                    break;
            }
        }        
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.menuWallpaper, 0, 0, null);
        
        //RENDERING OPTIONS       
        for(int i = 0; i<options.length; i++){      
            if(i == selection){
                 options[i].setSelected(true);
            }else{
                options[i].setSelected(false);
            }
            
            options[i].render(g);
                
        }
        
    }

/////GETTERS AND SETTERS     
    @Override
    public void enter() {
    }

    @Override
    public void exit() {
    }

    @Override
    public String getName() {
        return "pause";
    }

    @Override
    public Enums getId() {
        return id;
    }

    
}