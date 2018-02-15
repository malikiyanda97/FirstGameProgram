/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.spritesheets;

import java.awt.image.BufferedImage;

/**
 *
 * @author miyan
 */
public class SpriteSheets {
    
    public static BufferedImage nudePlayer;
    public static BufferedImage stone, grass;
    public static BufferedImage fireball;
   
  

     
    public static void playerInit(){
        ImageLoader nakedPlayerSheet = new ImageLoader(ImageLoader.loadImage("/player_Images/naked.png"));       
   
        //player crops 
        nudePlayer = nakedPlayerSheet.cropImage(0, 0, 32, 64);
    }

    public static void worldInit(){
        ImageLoader worldBackgroundSheet = new ImageLoader(ImageLoader.loadImage("/world_Images/worldSheet.png"));
    
        //Map crops  
        stone = worldBackgroundSheet.cropImage(135, 40, 64, 64);
        grass = worldBackgroundSheet.cropImage(64, 128, 64, 64);    
    
    }    
    
    public static void bulletInit(){
        ImageLoader fireballSheet = new ImageLoader(ImageLoader.loadImage("/util_Images/fireball.png"));

        //Fireball crops
        fireball = fireballSheet.cropImage(0, 64*4, 64, 64);
    }
    
    




}



    
