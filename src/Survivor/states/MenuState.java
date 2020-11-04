/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.Enums;
import Survivor.GameHandler;
import Survivor.entitiesManager.EntityHandler;
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
public class MenuState implements State {

    public Keyboard keyboard;
    private EntityHandler EH;
    public Mouse mouse;
    public GameButtons[] mOptions;
    private GameHandler GH;
    private Enums id;
    private int selection=0;
    private int RENDERING_GAP = 70;
    


    
    
    public MenuState(Enums id, Mouse mouse, Keyboard keybaord, GameHandler GH){
        super();
        this.GH = GH;
        this.id = Enums.gameState;
        this.mouse = mouse; 
        this.keyboard = keybaord;
        
      
        
    }
   
    @Override
    public void init() {
        mOptions = new GameButtons[5];
           
        //MENU OPTION
        mOptions[0] = new GameButtons("NEW GAME", 100, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);
        mOptions[1] = new GameButtons("LOAD GAME", 100+ 1* RENDERING_GAP,
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);   
        mOptions[2] = new GameButtons("INSTRUCTIONS", 100+ 2* RENDERING_GAP,
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);          
        mOptions[3] = new GameButtons("LEADERBOARD", 100 + 3* RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH);        
        mOptions[4] = new GameButtons("EXIT", 100+ 4*RENDERING_GAP, 
                     new Font("Cambria", Font.PLAIN, 30), new Font("Cambria", Font.BOLD, 50), 
                     Color.WHITE, Color.GRAY, GH); 
       
    }    

    @Override
    public void update(StateController sc) {
        System.out.println(mouse.getX() + "    " + mouse.getY());
        
        boolean clicked = false;
        for (int i = 0; i < mOptions.length; i++) {
            if(mOptions[i].intersects(new Rectangle(mouse.getX(), mouse.getY(), 2, 2))){
                selection = i;
                if(mouse.isLeftPressed())
                    clicked = true;
            }
        }
          
        if(clicked) 
            chooseOption(sc);
        


//        if(mouse.isLeftPressed())
//            StateManager.setState(GH.getGame().gameState); 


    }
    public void chooseOption(StateController sc){
        OUTER:
        if (selection < mOptions.length) {
            switch (selection) {
                case 0:
                    //System.out.println("PLAYING");
//                    sc.addState(new GameState(id, GH, EH));
                    sc.setState("game");
                    break OUTER;
                case 1:
                    System.out.println("LOAD GAME");
                    break OUTER;
                case 2:
                    System.out.println("INSTRUCTIONS");
                    break OUTER;
                case 3:
                    System.out.println("LEADERBOARD");
                    break OUTER;
                case 4:
                    System.out.println("EXITING");
                    System.exit(0);
                    break OUTER;
                default:
                    break;
            }
        }
    }

    @Override
    public void render(Graphics g) {       
        g.drawImage(Images.menuWallpaper, 0, 0, null);
        //Fonts.drawString(g, new Font("Arial", Font.HANGING_BASELINE, 35), Color.WHITE, "Survivor", 100,400);
      
        //RENDERING OPTIONS       
        for(int i = 0; i<mOptions.length; i++){      
            if(i == selection){
                 mOptions[i].setSelected(true);
            }else{
                mOptions[i].setSelected(false);
            }
            
            mOptions[i].render(g);
                
        }
        
        g.setColor(Color.WHITE);
        g.fillRect(mouse.getX(), mouse.getY(), 4, 4);    
        
    }
    
   //GETTERS AND SETTERS 
    @Override
    public void enter() {
    }

    @Override
    public void exit() {
    }

    @Override
    public String getName() {
        return "menu";
    }

    @Override
    public Enums getId() {
        return id;
    }

    
} 
    
