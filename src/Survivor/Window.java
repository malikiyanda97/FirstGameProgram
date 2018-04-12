/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author miyan
 */
public class Window {
    
    public Window(String title, int width, int height, Game game){
        
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
	frame.setMinimumSize(new Dimension(width, height));

	frame.add(game);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
	frame.setVisible(true);
        
    }
    
}
