/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malik.spaceattack;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author miyan
 */
public class Window {
    
    private JFrame window;
    private Canvas screen; 
    
    private String title;
    private int width, height;
    
    public Window(String title, int width, int height){
	this.title = title;
	this.width = width;
	this.height = height;
	
	createDisplay();
}

    private void createDisplay(){
	window = new JFrame(title);
	window.setSize(width, height);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.setLocationRelativeTo(null);
	window.setVisible(true);
        
        
        screen = new Canvas();
	screen.setPreferredSize(new Dimension(width, height));
	screen.setMaximumSize(new Dimension(width, height));
	screen.setMinimumSize(new Dimension(width, height));
        screen.setFocusable(false); 
	
	window.add(screen);
	window.pack();
    }
    
    public Canvas getScreen(){
        return screen;
    }
    
    public JFrame getWindow(){
        return window;
    }
    
}
