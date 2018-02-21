/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

import Survivor.entities.Player;
import Survivor.entitiesManager.EntityEnums;
import Survivor.entitiesManager.EntityHandler;
import Survivor.images.Images;
import Survivor.images.SpriteSheet;
import Survivor.input.Keyboard;
import Survivor.input.Mouse;
import Survivor.states.GameState;
import Survivor.states.MenuState;
import Survivor.states.StateManager;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


/**
 *
 * @author miyan
 */
public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Window window;
    private Thread thread;
    private static EntityHandler entityHandler;
    
   
    public int width, height;
    private final String title;
          
    //STATES
    public  StateManager menuState;
    public GameState gamestate;
    public MenuState menustate;
    
    //INPUT
    private Mouse mouse;
    
    
    //IMAGES
    private BufferedImage sheet = null;
    private SpriteSheet s;
    
    
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
       
        
        mouse = new Mouse(); 
    }
    
    public void initialise(){
        window = new Window(title, width, height, this);
        Images.init();
        
        //Entities 
        entityHandler = new  EntityHandler();
        
        //Mouse and Keyboard Listeners 
        this.addKeyListener(new Keyboard(entityHandler));
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        
        //Sprite sheet
        sheet = Images.loadImage("/player_Images/naked.png");
        s = new SpriteSheet(sheet);
        
  
        //Player Entity 
        entityHandler.addEntity(new Player(100,100,EntityEnums.Player,entityHandler, s));
        
        //states      
        menuState = new MenuState(mouse);
        StateManager.setState(menuState);
        
        menuState.stateInit();
   
        
    }

    public static EntityHandler getEntityHandler() {
        return entityHandler;
    }
    
    @Override
    public void run(){
        gameLoop();
    }
    
    public void update(){
        entityHandler.update();
        if(StateManager.getState() != null){
            StateManager.getState().update();
        
        }
         
    }
    
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, 1000, 563);
        //////////////START DRAW AREA////////////////////////////
        
             
       if(StateManager.getState() != null){
           StateManager.getState().render(g);
       }
       
       entityHandler.render(g);
        
        ///////////////END DRAW AREA///////////////////////////
        bs.show();
        g.dispose();
    }

    public synchronized void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
        
    }
    
    public synchronized void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace(); 
        }
    }    
    
    
   public void gameLoop(){
       initialise();
       this.requestFocus();
       long lastTime = System.nanoTime();
       double amountofTicks = 60.0;
       double ns = 1000000000 / amountofTicks;
       double delta = 0;
       long timer = System.currentTimeMillis();
       int frames = 0;
       while(running){
           long now  = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                delta--;
                
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
                
            }      
        }
        stop();
   }
   
   //GETTERS AND SETTERS 
   public Mouse getMouse(){
       return mouse;
   }


}