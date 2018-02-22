/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

import Survivor.entitiesManager.EntityHandler;
import Survivor.images.Images;
import Survivor.input.Keyboard;
import Survivor.input.Mouse;
import Survivor.states.GameState;
import Survivor.states.MenuState;
import Survivor.states.StateManager;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;


/**
 *
 * @author miyan
 */
public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Window window;
    private Thread thread;
    
   
    public int width, height;
    private final String title;
          
    //STATES
    public  StateManager State;
    public GameState gameState;
    public MenuState menuState;
    
    //INPUT
    private Keyboard keyboard;
    private Mouse mouse;
    
    //ENTITY HANDLER
    private EntityHandler EH;
        
    //GAME HANDLER 
    private GameHandler GH;
    
    
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
    }
    
    public void init(){
        window = new Window(title, width, height, this);
        
        //MOUSE INPUT
        mouse = new Mouse();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        
        //IMAGES
        Images.init();
        
        //ENTITY HANDLER 
        EH = new EntityHandler();
        
        //GAME HANDLER
        GH = new GameHandler(this);  
        
        //KEYBOARD INPUT 
        this.addKeyListener(new Keyboard(EH));
       
        //STATES
        gameState = new GameState(GH,EH);
        menuState = new MenuState(mouse,GH);
        StateManager.setState(menuState);        
        
        
        
    }

    @Override
    public void run(){
        gameLoop();
    }
    
    public void update(){
      
     
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
        Graphics2D g2d = (Graphics2D) g;
        //g.clearRect(0, 0, 1200, 800);
        //////////////START DRAW AREA////////////////////////////
        
       if(StateManager.getState() != null){
           StateManager.getState().render(g);
       }
        
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
       init();
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

   public EntityHandler getEH() {
        return EH;
   }
}