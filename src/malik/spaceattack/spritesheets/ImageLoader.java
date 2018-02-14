    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack.spritesheets;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author miyan
 */
public class ImageLoader {
    
    private static BufferedImage image = null;
    private BufferedImage sheet;
    
    
    public ImageLoader(BufferedImage sheet){
        this.sheet = sheet;
        
    }
    
    public static BufferedImage loadImage(String path){
       
        try{
            image = ImageIO.read(ImageLoader.class.getResource(path));
            return image;
        }
        catch(IOException e ){
            e.printStackTrace();
            //System.out.println("Error - " + e.getMessage());
            System.exit(1);
        }
        return null;
    }
    
    public static BufferedImage cropImage(int x, int y, int width, int height){
         return ImageLoader.image.getSubimage(x, y, width, height);
    }
    
    
}













//    public BufferedImage loadImage(String path){
//        try {
//            image = ImageIO.read(ImageLoader.class.getResource(path));
//            return image;
//        } catch (IOException ex) {
//            System.out.println("Error - " + ex.getMessage());
//        }
//        return null;
//    }
//
//
//        if(image == null){
//            image = LoadImage("/textures/fireball3.gif");
//            
//        }else{
//            System.out.println("Image Couldn't be loaded");
//        }
//        