/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

import Survivor.entitiesManager.EntityHandler;
import Survivor.images.Camera;
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
    public Thread thread;
    
   
    public int width, height;
    private final String title;
    
    public Camera camera;
          
    //STATES
    public  StateManager State;
    public GameState gameState;
    public MenuState menuState;

    //INPUT
    public Keyboard keyboard;
    public Mouse mouse;
    
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
        mouse = new Mouse(GH);
        this.addMouseListener(mouse);       
        this.addMouseMotionListener(mouse);
      
        //IMAGES
        Images.init();
        
        //ENTITY HANDLER 
        EH = new EntityHandler();
        
        //GAME HANDLER
        GH = new GameHandler(this, gameState);  
        
        //KEYBOARD INPUT 
        this.addKeyListener(new Keyboard(EH,GH));
       

        
        //STATES
        gameState = new GameState(GH,EH);
        menuState = new MenuState(mouse,GH);
        StateManager.setState(menuState);        
        
    }



    @Override
    public void run(){
        gameLoop();
        stop(); //Stops the thread.
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
        if(!running) running = true; //Start Game
        thread = new Thread(this);
        thread.start();
        
    }
    
    public synchronized void stop(){
        if(running) running = false; //Stop Game
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
       
       double FPS = 60.0;
       double ticksPerSecond = 1000000000 / FPS;
       
       double delta = 0;
       long timer = System.currentTimeMillis();
       int frames = 0;
       
       while(running){
           long now  = System.nanoTime();
            delta += (now - lastTime) / ticksPerSecond;
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