/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardestgame;

import java.awt.Graphics;
//import javafx.scene.paint.Color;
import java.awt.Color;
import java.awt.Rectangle;
/**
 *
 * @author 800215
 */
public class Player {
    private int x,y;
    private final static int WIDTH = 50, HEIGHT = 50, SPEED = 10;
    //constant (all capital letters) ~ final
    private final static Color COLOR = Color.RED;
    
    
    //constructors
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //1. draw outline on shape
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
    
    //7. implement method playerVsEnemy
    //**
     //* Checks if player collides with an enemy
     //* and respawns player if it does
     //* @param enemy the enemy to check for collision against
     //* @param start the player respawns in middle of start if collides with enemy
     //*/
    public void playerVsEnemy(Enemy enemy, Goal start) {
        Rectangle playerBounds = new Rectangle(x,y,WIDTH,HEIGHT);
        Rectangle enemyBounds = new Rectangle(enemy.getX(),enemy.getY(),enemy.getWIDTH(),enemy.getHEIGHT());
        if (playerBounds.intersects(enemyBounds)) {
            this.x = (int)(Math.random() * start.getWidth()-this.WIDTH/2);
            this.y = (int)(Math.random() * start.getHeight()-this.HEIGHT/2);
        }
    }

    //8.a. implement method isInBounds
    //**
     //* Determines if player is still in bounds
     //* @param border boundaries of the room
     //* @return isInBounds Whether the player is in bounds or not
     //*/
     boolean isInBounds(Border border) {
        if (this.x > border.getX()) {
          this.x = border.getX() - this.x;
        }
        if (this.y > border.getY()) {
          this.y = border.getY() - this.y;
        }
        return false;
     }

    //9. implement method playerVsGoal
    /**
     //* Determines if player reaches a goal
     //* @param finish goal player might have reached
    //* @return didReachGoal Whether the player reached the goal or not
     //*/
    // public boolean playerVsGoal(Goal finish) {

    // }
    
    
    public void move(int dx,int dy) {
        //8.b. player can only move if still in bounds
        x += SPEED * dx;
        y += SPEED * dy;
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
