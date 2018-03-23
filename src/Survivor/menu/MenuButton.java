/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.menu;

import Survivor.GameHandler;
import Survivor.util.Fonts;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class MenuButton extends Rectangle{
    private String text;
    private int textPos;
    private Font font,selectedFont;
    private Color color, selectedColor;    
    private boolean selected;
    
    private GameHandler GH;
            
    
    public MenuButton(String text, int textPos, Font font, Font selectedFont, Color color, Color selectedColor,GameHandler GH) {
        this.GH = GH;
        this.text = text;
        this.textPos = textPos;
        this.font = font;
        this.selectedFont = selectedFont;
        this.color = color;
        this.selectedColor = selectedColor;
    }
    
    
    public void update(){
        
    }
    
    public void render(Graphics g){
        if(selected == true){
            Fonts.drawString(g, selectedFont, selectedColor, text, textPos);
        }else{
            Fonts.drawString(g, font, color, text, textPos);
        }
        
        //Bounds 
        FontMetrics fm  = g.getFontMetrics();
        this.x = 100;
        this.y = textPos - fm.getHeight();
        this.width = fm.stringWidth(text);
        this.height = fm.getHeight();
        g.drawRect(x, y, width, height);
    }
    
    
    
    //Getters and Setters 
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
}
