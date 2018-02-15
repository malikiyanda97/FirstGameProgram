///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package malik.spaceattack.states;
//
//import java.awt.Graphics;
//import malik.spaceattack.Game;
//import malik.spaceattack.entities.Controller;
//import malik.spaceattack.entities.EntityHandler;
//import malik.spaceattack.entities.ID;
//import malik.spaceattack.entities.Player;
//
///**
// *
// * @author miyan
// */
//public class GameState extends StateManager {
//    
//    
//    private Player player;
//    private EntityHandler handler;
//    private Controller c;
//    
//    public GameState(Game game){
//        super(game);
//        handler.addEntity(new Player(100,100,ID.Player, handler));
//        c = new Controller(game);
//        
//    }
//
//    @Override
//    public void Update(){
//        handler.update();
//    }
//
//    @Override
//    public void Render(Graphics g) {
//        player.render(g);
//        c.render(g);
//
//    }
//    
//}
