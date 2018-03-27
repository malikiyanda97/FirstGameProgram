/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.Enums;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public interface State {
    
    public void init();
    public void enter();
    public void update(StateController stateController);
    public void render(Graphics g);
    public void exit();
    public String getName();
    public Enums getId();
    
}
