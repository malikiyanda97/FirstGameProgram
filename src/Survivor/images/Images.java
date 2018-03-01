/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author miyan
 */
public class Images {
    
    public static BufferedImage nakedPlayer;
    public static BufferedImage levelOne;
    
    public static void init(){
        
        //PLAYER SPRITESHEETS AND IMAGES
        Sheets nakedPlaySheet = new Sheets(Images.loadImage("/player_Images/naked.png"));
        nakedPlayer = nakedPlaySheet.cropImage(0, 60*3, 30, 60);
        
        //LEVEL 1 IMAGE
        Sheets levelOneSheet = new Sheets(Images.loadImage("/world_Images/Wave1.png"));
        levelOne = levelOneSheet.cropImage(0, 0, 64, 64);
        //levelOne = Images.loadImage("/world_Images/level1.0.png");
        
    
    }
 
    
    
    
    //IMAGE LOADER 
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(Images.class.getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
