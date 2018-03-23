/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public class Fonts {
   
    
    public static void drawString(Graphics g, Font f, Color c, String text, int x, int y){
        g.setColor(c);
        g.setFont(f);
        g.drawString(text, x,y);
    }
        
    public static void drawString(Graphics g, Font f, Color c, String text){
        FontMetrics fs =g.getFontMetrics(f);
        int x = 1400 - fs.stringWidth(text) /2; 
        int y = 1400 - fs.getHeight() /2 + fs.getAscent();
        drawString(g,f,c, text,x,y);
        
    }    
    
    public static void drawString(Graphics g, Font f, Color c, String text, double x){
        FontMetrics fs =g.getFontMetrics(f); 
        int y = 1400 - fs.getHeight() /2 + fs.getAscent();
        drawString(g,f,c, text,(int) x,y);   
    }     
    
    public static void drawString(Graphics g, Font f, Color c, String text,int y){
        FontMetrics fs =g.getFontMetrics(f);
        int x = 100; 
        drawString(g,f,c, text,x,y);
        
    }      
    
    
    
    
}