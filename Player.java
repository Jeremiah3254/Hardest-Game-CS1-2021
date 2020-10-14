/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardestgame;

import java.awt.Graphics;
//import javafx.scene.paint.Color;
import java.awt.Color;
/**
 *
 * @author 800215
 */
public class Player {
    private int x,y;
    private final static int WIDTH = 50, HEIGHT = 50;
    //constant (all capital letters) ~ final
    private final static Color COLOR = Color.RED;
    
    
    //constructors
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
    
    //getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
        
    
}
