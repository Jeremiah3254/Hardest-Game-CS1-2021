/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardestgame;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author 800215
 */
public class Enemy {
    
    private int x, y, vx, vy;
    private final static int SPEED = 2;
    private final static int WIDTH = 25, HEIGHT = 25;
    private final static Color COLOR = Color.BLUE;

    public Enemy(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    //4.a constructor

    //4.b draws a circle (oval)
    
    
    public void hitsWall(Enemy enemy) {
        while (enemy.x > 25) {
            enemy.x = enemy.x-120;
        }
    }
    
    
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.drawOval(x, y, WIDTH, HEIGHT);
        g.fillOval(x, y, WIDTH, HEIGHT);
    }
    
    //6.a. implement method collideWorldBounds
    /**
     * Checks if enemy hits border, if so, turns around
     * @param border Boundaries of the room
     */
    public void collideWorldBounds(Border border) {
        //top wall
        if (this.y < border.getY()) {
              this.vy *= -1;
          }
        if (this.y > border.getHeight()-25) {
              this.vy *= -1;
          }
        if (this.x < border.getX()) {
              this.vx *= -1;
          }
        if (this.x > border.getWidth()-25) {
              this.vx *= -1;
          }
    }
    
    
    public void move(){
        
        x += vx;
        y += vy;
       
     }
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static Color getCOLOR() {
        return COLOR;
    }
    
    
    
    
    
}
