/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.GameHandler;
import Survivor.images.Images;
import Survivor.input.Mouse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.MouseEvent;

/**
 *
 * @author miyan
 */
public class MenuState extends StateManager {

  
    public Mouse mouse;
    public MenuButton[] options;
    private int selection;
    private int RENDERING_GAP = 70;

    
    public MenuState(Mouse mouse, GameHandler GH){
        super(GH);
        this.mouse = mouse;        
        
        options = new MenuButton[3];
           
        //MENU OPTION
        options[0] = new MenuButton("PLAY", 100, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);
        options[1] = new MenuButton("OPTIONS", 100 + 1* RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);        
        options[2] = new MenuButton("EXIT", 100+ 2*RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH); 
        
    }


   
    @Override
    public void init() {
       
    }    

    @Override
    public void update() {
        System.out.println(mouse.getX() + "    " + mouse.getY());
        
        boolean clicked = false;
        for (int i = 0; i < options.length; i++) {
            if(options[i].intersects(new Rectangle(mouse.getX(), mouse.getY(), 2, 2))){
                selection = i;
                if(mouse.isLeftPressed())
                    clicked = true;
            }
        }
        
        if(clicked) chooseOption();

//        if(mouse.isLeftPressed())
//            StateManager.setState(GH.getGame().gameState); 


    }
    public void chooseOption(){
        while(selection < 3){
            if(selection == 0){
                System.out.println("PLAYING");
                StateManager.setState(GH.getGame().gameState);
                break;
            }               
            else if(selection == 1){
                System.out.println("OPTIONS");
                break;
            }
            else if(selection == 2){
                System.out.println("EXITTING");
                System.exit(0);
                break;
            }
            
                
        }
    }
//    
//    public void select(){
//        switch(selection){
//            case 0:
//                System.out.println("Play");
//                break;
//            case 1:
//                System.out.println("Options");
//                break;
//            case 2:
//                System.out.println("Exit");
//               
//                break;
//        }
//    }

    @Override
    public void render(Graphics g) {       
        g.drawImage(Images.menuWallpaper, 0, 0, null);
        //Fonts.drawString(g, new Font("Arial", Font.HANGING_BASELINE, 35), Color.WHITE, "Survivor", 100,400);
      
        //RENDERING OPTIONS       
        for(int i = 0; i<options.length; i++){      
            if(i == selection){
                 options[i].setSelected(true);
            }else{
                options[i].setSelected(false);
            }
            
            options[i].render(g);
                
        }
        
        g.setColor(Color.WHITE);
        g.fillRect(mouse.getX(), mouse.getY(), 4, 4);    
        
    }
} 
    
