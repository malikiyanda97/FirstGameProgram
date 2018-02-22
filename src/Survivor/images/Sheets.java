/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.images;

import java.awt.image.BufferedImage;

/**
 *
 * @author miyan
 */
public class Sheets {
    
    private BufferedImage sheet;
    
    public Sheets(BufferedImage sheet){
        this.sheet = sheet;
        
    }
   
    public BufferedImage cropImage(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }
}
