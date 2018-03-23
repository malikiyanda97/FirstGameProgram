/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.menu;

import Survivor.GameHandler;
import Survivor.images.Images;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public class Menu {
    
    GameHandler GH;
    private int RENDERING_GAP = 70;
    private final MenuButton[] options;
    private int Selection;
    
    
    public Menu(GameHandler GH){
        this.GH = GH;   
        options = new MenuButton[3];
           
        //MENU OPTION
        options[0] = new MenuButton("PLAY", 100, 
                     new Font("Cambria", Font.PLAIN, 40), new Font("Cambria", Font.BOLD, 40), 
                     Color.WHITE, Color.GRAY, GH);
        options[1] = new MenuButton("OPTIONS", 100 + 1* RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 40), new Font("Cambria", Font.BOLD, 40), 
                     Color.WHITE, Color.GRAY, GH);        
        options[2] = new MenuButton("EXIT", 100+ 2*RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 40), new Font("Cambria", Font.BOLD, 40), 
                     Color.WHITE, Color.GRAY, GH); 

    }
    
    public void update(){
        
    }
    
    public void render(Graphics g){
        g.drawImage(Images.menuWallpaper, 0, 0, null);
        //Fonts.drawString(g, new Font("Arial", Font.HANGING_BASELINE, 35), Color.WHITE, "Survivor", 100,400);
      
        //RENDERING OPTIONS       
        for(int i = 0; i<options.length; i++){      
            if(i == Selection){
                 options[i].setSelected(true);
            }else{
                options[i].setSelected(false);
            }
            
            options[i].render(g);
                
        }
        
    }
    
    
}
