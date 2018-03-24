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
    public static BufferedImage demonEnemy;
    public static BufferedImage droneEnemy;
    public static BufferedImage levelOne;
    public static BufferedImage castleBase;
    public static BufferedImage Background;
    public static BufferedImage ground;
    public static BufferedImage stones;    
    public static BufferedImage grass;  
    public static BufferedImage highGrass;
    public static BufferedImage walls;
    public static BufferedImage menuWallpaper;
    public static BufferedImage menuSub;
    
    public static void init(){
        
        //PLAYER SPRITESHEETS AND IMAGES
        Sheets nakedPlaySheet = new Sheets(Images.loadImage("/player_Images/naked.png"));
        nakedPlayer = nakedPlaySheet.cropImage(0, 60*3, 30, 60);
        
        //Enemy Demon Sprite Sheet 
        Sheets demonSheets = new Sheets(Images.loadImage("/player_Images/enemyDemon.png"));
        demonEnemy = demonSheets.cropImage(0, 0, 64, 64);
        
        
         //Enemy Drone Sprite Sheet 
        Sheets droneSheets = new Sheets(Images.loadImage("/player_Images/enemyDrone.png"));
        droneEnemy = droneSheets.cropImage(0, 0, 55, 50);

        //Castle Base Sprite Sheet 
        Sheets baseSheet = new Sheets(Images.loadImage("/base_Images/cityBase.jpg"));
        castleBase = baseSheet.cropImage(0, 0, 252, 190);
        
        //Menu Wallpaper
        Sheets menuSheet = new Sheets(Images.loadImage("/menu_Images/battle.png"));
        menuWallpaper = menuSheet.cropImage(100, 0, 1400, 1000);

        //background Sprite Sheets 
        Sheets backSheet = new Sheets(Images.loadImage("/world_Images/background.png"));
        Sheets wallSheet = new Sheets(Images.loadImage("/world_Images/picwall.png"));
        Background = backSheet.cropImage(0, 0, 32*4, 64);
        ground = backSheet.cropImage(0, 64, 90, 86);
        stones = backSheet.cropImage(64*17, 180, 64, 64);
        grass = backSheet.cropImage(90, 64*10, 70,90);
        highGrass = backSheet.cropImage(980, 400, 80,80);
        
        walls = wallSheet.cropImage(0, 0, 32, 32);
       
        
        
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
