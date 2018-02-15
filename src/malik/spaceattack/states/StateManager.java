///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package malik.spaceattack.states;
//
//import java.awt.Graphics;
//import malik.spaceattack.Game;
//
///**
// *
// * @author miyan
// */
//public abstract class StateManager {
//    
//    
//    private static StateManager currentstate = null;
//    public static void setState(StateManager state){
//        currentstate = state;
//    }
//    
//    public static StateManager getState(){
//        return currentstate;
//    }
//
//    
//    //CLASS
//    
//    protected Game game;
//    
//    public StateManager(Game game){
//        this.game = game;
//    }
//
//    public abstract void Update();
//    public abstract void Render(Graphics g);
//   
//   
//    
//}
