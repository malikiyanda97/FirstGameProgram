/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.survivo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import malik.survivor.entitiesManager.EntityHandler;


/**
 *
 * @author miyan
 */
public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Window window;
    private Thread thread;
    private EntityHandler handler;
    
   
    public int width, height;
    private final String title;
    
    
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
       
    }
    
    public void initialise(){
        window = new Window(title, width, height, this); 
        handler = new EntityHandler();
    }
    
    @Override
    public void run(){
        gameLoop();
    }
    
    public void update(){
        handler.update();
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
        
        g.setColor(Color.red);
        g.fillRect(0, 0, 1000, 563);
        
        handler.render(g);
        
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
    







}