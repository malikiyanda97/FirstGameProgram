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
public class WorldSprite {
    
 
    public static BufferedImage stone, grass, gstone;
    public static final int width = 64, height = 64;
    
    public static void init(){
        ImageLoader sheet = new ImageLoader(ImageLoader.loadImage("/world_Images/WorldSpriteSheet.png"));
       
        //Map Crops  
        stone = sheet.cropImage(135, 40, width, height);
        grass = sheet.cropImage(64, 128, width, height);
    
    }
    
}
