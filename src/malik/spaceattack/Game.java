/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import malik.spaceattack.entities.EntityHandler;
import malik.spaceattack.entities.ID;
import malik.spaceattack.entities.Player;
import malik.spaceattack.input.KeyInput;
import malik.spaceattack.spritesheets.SpriteSheets;


/**
 *
 * @author miyan
 */
public class Game extends Canvas implements Runnable {
    
    private Window window;
    public int width, height;
    private final String title;
    
    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;
    
    private Thread thread;
    private EntityHandler handler;
    private Camera camera;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //INPUT
    private KeyInput keyInput;
   
    
    
    //STATES 
//    private StateManager gameState;
//    private StateManager menuState;
    
   

    public Game(String title, int width, int height){
	this.width = width;
	this.height = height;
        this.title = title;
        


    }
    
    private void init(){
        window = new Window(title, width, height);
        camera = new Camera(0,0);
        
        handler = new EntityHandler();
        this.addKeyListener(new KeyInput(handler));
        
        handler.addEntity(new Player(100, 100, ID.Player, handler));
        
        //SpriteSheets
        SpriteSheets.playerInit();
        SpriteSheets.bulletInit();
        SpriteSheets.worldInit();

       
            
//        gameState = new GameState(this);
//        menuState = new MenuState(this);
//        StateManager.setState(gameState); 
  
           
    }
       
    private void Update(){
        for (int i = 0; i < handler.entities.size(); i++) {
            if(handler.entities.get(i).getId() == ID.Player){
                camera.tick(handler.entities.get(i));
            }
        }
        handler.update();
        
       
//        if(StateManager.getState() != null){
//            StateManager.getState().Update();
//        }              

    }
	
    private void Render(){
        bs = window.getScreen().getBufferStrategy();
        if(bs == null){
            window.getScreen().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g.clearRect(0, 0, width, height);
        //////////////////BIGINNING////////////////////////
        
        g.setColor(Color.red);
        g.fillRect(0, 0, 1100, 800);
        
        
        g2d.translate(camera.getX(), camera.getY());
        
        handler.render(g);
        
        g2d.translate(camera.getX(), camera.getY());
            
//        if(StateManager.getState() != null){
//            StateManager.getState().Render(g);
//        }
        
            
        ////////////////// //END////////////////////////////
        bs.show();
        g.dispose();           
		
	}
       
	
    @Override
	public void run(){
		
		init();
                long lastTime = System.nanoTime();
                double amountOfTicks = 60.0;
                double ns = 1000000000 / amountOfTicks;
                double delta = 0;
                long timer = System.currentTimeMillis();
                int updates = 0;
                int frames = 0;
                while(running){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while(delta >= 1){
		Update();
		updates++;
		delta--;
	}
                Render();
                frames++;
                
                if(System.currentTimeMillis() - timer > 1000){
                    timer += 1000;
                    System.out.println("FPS: " + frames + " TICKS: " + updates);
                    frames = 0;
                    updates = 0;
	}
}
		
		
	}
      
	public synchronized void start(){
		if(running)
                    return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}   
	
	public synchronized void stop(){
		if(!running)
                    return;
		running = false;
		try {
                    thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
        
        
        //GETTERS AND SETTERS 
        public KeyInput getKeyInput(){
            return keyInput;
        }
    
}
