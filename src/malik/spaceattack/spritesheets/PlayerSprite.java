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
public class PlayerSprite {
    
    public static BufferedImage nudePlayer;
 //   public static final int width = 32, height = 64;
    
    public static void init(){
        ImageLoader sheet = new ImageLoader(ImageLoader.loadImage("/player_Images/naked.png"));
        
   
        //player crops 
        nudePlayer = sheet.cropImage(0, 0, 32, 64);
    
    }
}
    

