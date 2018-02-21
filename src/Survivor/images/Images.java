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
    
        //private static BufferedImage nakedPlayerSheet;
    
    public static void init(){
        //nakedPlayerSheet = Images.loadImage("/player_Images/naked.png");
    }
    
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(Images.class.getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
