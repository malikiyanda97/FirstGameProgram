 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.GameHandler;
import Survivor.entities.Base;
import Survivor.entities.Wall;
import Survivor.entities.Drone;
import Survivor.entities.Survivor;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.EntityHandler;
import Survivor.Enums;
import Survivor.images.Camera;
import Survivor.images.Images;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author miyan
 */
public class GameState extends StateManager {
    
    
    public Survivor player;
    public Camera camera;
    private EntityHandler EH; //only for keyboard use 
    
    public GameState(GameHandler GH, EntityHandler EH){
        super(GH);
        this.EH = EH;
         

        init();   
       
      
        
    }
 
   
    @Override
    public void init(){
        camera = new Camera(0,0);
        loadLevelOne(Images.levelOne);
        
    }
    
    @Override
    public void update() {
        for(int i = 0; i < GH.getGameEH().entities.size(); i++){
            Entities tempEntity = GH.getGameEH().entities.get(i);
            
            if(GH.getGameEH().entities.get(i).getId() == Enums.Survivor){
                camera.update(GH.getGameEH().entities.get(i));
                
            }
           
        }

        GH.getGameEH().update();
               
    }

    @Override
    public void render(Graphics g) {
//        g.setColor(Color.LIGHT_GRAY);
//        g.fillRect(0, 0, 1400, 1000);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.translate(-camera.getX(), -camera.getY());
        
        for (int xx = 0; xx < 1400 + camera.getX(); xx+=64) {
            for(int yy = 0; yy< 1000+ camera.getY(); yy+= 64){
                g.drawImage(Images.grass, xx, yy, null);
            }
                
       }
        
        GH.getGameEH().render(g);
        
        g2d.translate(camera.getX(), camera.getY());
        
        
    }
    

    private void loadLevelOne(BufferedImage image){
        
        int w = image.getWidth();
        int h = image.getHeight();
        
        
        for (int xx = 0; xx < w; xx++){
            for (int yy = 0; yy < h; yy++) {
                int pixel  = image.getRGB(xx, yy);  
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
               
                
                if(red == 255)
                    GH.getGameEH().addEntity(new Wall(Enums.Wall,xx*32, yy*32,GH));
                
                if(blue == 255 & green == 0)
                    GH.getGameEH().addEntity(new Survivor(Enums.Survivor, xx*32, yy*32,GH,EH));
                
                if(green == 255 & blue == 0)
                    GH.getGameEH().addEntity(new Drone(Enums.Enemy, xx*32, yy*32,GH));
                                
                if(green == 255 & blue == 255)
                    GH.getGameEH().addEntity(new Base((Enums.Base), xx*32, yy*32, GH));
                                
            }
           
        }
    }
    
    //getters and setters 
    
    public Survivor player(){
        return player;  
    }
    
}
