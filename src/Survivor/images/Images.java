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
    
    public static BufferedImage[] playerDown, playerUp, playerRight, playerLeft;
    
    //ENTITIES
    public static BufferedImage nakedPlayer;
    public static BufferedImage droneEnemy;
    public static BufferedImage soliderTank;
    
    //ANIMATION
//    
//    public static BufferedImage tankdown;
//    
//    public static BufferedImage td1;
//    public static BufferedImage td2;
//    public static BufferedImage td3;    
//    public static BufferedImage td4;
//    public static BufferedImage td5;
//    public static BufferedImage td6;
//    public static BufferedImage td7;
//    
//    public static BufferedImage tankup;
//    
//    public static BufferedImage tu1;
//    public static BufferedImage tu2;
//    public static BufferedImage tu3;    
//    public static BufferedImage tu4;
//    public static BufferedImage tu5;
//    public static BufferedImage tu6;
//    public static BufferedImage tu7;
//
//    public static BufferedImage tankright;
//    
//    public static BufferedImage tr1;
//    public static BufferedImage tr2;
//    public static BufferedImage tr3;    
//    public static BufferedImage tr4;
//    public static BufferedImage tr5;
//    public static BufferedImage tr6;
//    public static BufferedImage tr7;
//
//    public static BufferedImage tankleft;
//    
//    public static BufferedImage tl1;
//    public static BufferedImage tl2;
//    public static BufferedImage tl3;    
//    public static BufferedImage tl4;
//    public static BufferedImage tl5;
//    public static BufferedImage tl6;
//    public static BufferedImage tl7;
    
    //GAME
    public static BufferedImage levelOne;
    public static BufferedImage castleBase;
    public static BufferedImage Background;
    public static BufferedImage ground;
    public static BufferedImage stones;    
    public static BufferedImage grass;  
    public static BufferedImage highGrass;
    public static BufferedImage walls;
   
    
    //MENU
    public static BufferedImage menuWallpaper;
    public static BufferedImage menuSub;
    
    //HEAlTH BAR
    public static BufferedImage healthB;
    public static BufferedImage healthEnemy;
    public static BufferedImage healthPlayer;
    public static BufferedImage healthBoarder;
    
    public static void init(){
        
        playerDown = new BufferedImage[7];
        playerUp= new BufferedImage[7];
        playerRight = new BufferedImage[7];
        playerLeft = new BufferedImage[7];
        
        
                  
        //TANK DOWN ANINIAMTION/IMAGES
        Sheets tankdownsheet = new Sheets(Images.loadImage("/player_Images/tankAnimation/tankdown.png"));
        playerDown[0] = tankdownsheet.cropImage(8, 15, 64,64);
        playerDown[1] = tankdownsheet.cropImage(94, 15, 64,64);
        playerDown[2] = tankdownsheet.cropImage(178, 15, 64,64);
        playerDown[3] = tankdownsheet.cropImage(262, 15, 64,64);
        playerDown[4] = tankdownsheet.cropImage(345, 15, 64,64);
        playerDown[5] = tankdownsheet.cropImage(428, 15, 64,64);
        playerDown[6] = tankdownsheet.cropImage(512, 15, 64,64); 
        
        soliderTank = tankdownsheet.cropImage(8, 15, 64, 64);
                
        //TANK UP ANIMATION/IMAGES
        Sheets tankupsheet = new Sheets(Images.loadImage("/player_Images/tankAnimation/tankup.png"));
        playerUp[0] = tankupsheet.cropImage(10, 15, 64, 64);
        playerUp[1] = tankupsheet.cropImage(94, 15, 64, 64);
        playerUp[2] = tankupsheet.cropImage(178, 15, 64, 64);
        playerUp[3] = tankupsheet.cropImage(262, 15, 64, 64);
        playerUp[4] = tankupsheet.cropImage(345, 15, 64, 64);
        playerUp[5] = tankupsheet.cropImage(430, 15, 64, 64);
        playerUp[6] = tankupsheet.cropImage(515, 15, 64, 64);
        
        //TANK RIGHT ANIMATION/IMAGES
        Sheets tankrightsheet = new Sheets(Images.loadImage("/player_Images/tankAnimation/tankright.png"));
        playerRight[0] = tankrightsheet.cropImage(14, 9, 64, 64);
        playerRight[1] = tankrightsheet.cropImage(14, 94, 64, 64);
        playerRight[2] = tankrightsheet.cropImage(14, 178, 64, 64);
        playerRight[3] = tankrightsheet.cropImage(14, 262, 64, 64);
        playerRight[4] = tankrightsheet.cropImage(14, 345, 64, 64);
        playerRight[5] = tankrightsheet.cropImage(14, 430, 64, 64);
        playerRight[6] = tankrightsheet.cropImage(14, 515, 64, 64);        

        //TANK LEFT ANIMATION/IMAGES
        Sheets tankleftsheet = new Sheets(Images.loadImage("/player_Images/tankAnimation/tankleft.png"));
        playerLeft[0] = tankleftsheet.cropImage(14, 9, 64, 64);
        playerLeft[1] = tankleftsheet.cropImage(14, 94, 64, 64);
        playerLeft[2] = tankleftsheet.cropImage(14, 178, 64, 64);
        playerLeft[3] = tankleftsheet.cropImage(14, 262, 64, 64);
        playerLeft[4] = tankleftsheet.cropImage(14, 345, 64, 64);
        playerLeft[5] = tankleftsheet.cropImage(14, 430, 64, 64);
        playerLeft[6] = tankleftsheet.cropImage(14, 515, 64, 64); 


         //Enemy Drone Sprite Sheet 
        Sheets droneSheets = new Sheets(Images.loadImage("/player_Images/enemyDrone.png"));
        droneEnemy = droneSheets.cropImage(0, 0, 50, 50);

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
        
        //HEALTH BARS IMAGES 
        healthB = Images.loadImage("/player_Images/healthBackground.png");
        healthEnemy = Images.loadImage("/player_Images/healthForeground.png");
        healthPlayer = Images.loadImage("/player_Images/healthPForeground.png");
        healthBoarder = Images.loadImage("/player_Images/healthBoarder.png");
        
        
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
