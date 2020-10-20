package hardestgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jeremiah Pfaff
 */
public class HardestGame extends JPanel implements KeyListener, MouseListener {

    private Timer timer;
    private int frameCount = 0;
    private Player player;
    private Border room1;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Goal finish;
    private Goal start;
    
    public HardestGame() {
        this.room1 = new Border(0,0,800,600);
        this.player = new Player(50,300);
        this.finish = new Goal(700,0,100,600,false);
        //this.enemy1 = new Enemy(50,25,50,50);
        //this.enemy2 = new Enemy(50,100,50,50);
        this.start = new Goal(0,0,100,600,false);
        this.enemy1 = new Enemy(0,25,-5,-5);
        this.enemy2 = new Enemy(0,100,-10,-10);
        this.enemy3 = new Enemy(0,40,-7,-7);
        this.enemy4 = new Enemy(0,70,-11,-11);
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/60); //fps 12
    }
    
   
    
   //50,300 player
    //400,300,1,1 enemy
    //0,100,100,600,false start
    // 700,100,100,100,600,true finish
    // 0,100,800,600; border
    
    
    
     @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        frameCount++;
        
        
        this.setBackground(Color.black);		
        
        
        
        
        room1.draw(g);	
        finish.draw(g);
        start.draw(g);
        player.draw(g);
        enemy1.draw(g);
        enemy2.draw(g);
        enemy3.draw(g);
        enemy4.draw(g);
        player.playerVsEnemy(enemy1, start);
        player.playerVsEnemy(enemy2, start);
        player.playerVsEnemy(enemy3, start);
        player.playerVsEnemy(enemy4, start);
        enemy1.collideWorldBounds(room1);
        enemy2.collideWorldBounds(room1);
        enemy3.collideWorldBounds(room1);
        enemy4.collideWorldBounds(room1);
        enemy1.move();
        enemy2.move();
        enemy3.move();
        enemy4.move();
        //player.isInBounds(room1);
        
        //10. call any methods needed to make interactions happen
        
        
    }
     
    
     
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            repaint();
        }
    }
    
    public static void main(String[] args) {
        JFrame j = new JFrame("Blobby Game");
        Container c = new HardestGame();
        j.add(c);
        j.pack();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(800, 600);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.addKeyListener((KeyListener) c);
        j.addMouseListener((MouseListener) c);
    }
    
     @Override
    public void keyPressed(KeyEvent e) {
        //8.c. update calls to player.move based on 8.b
        System.out.printf("\nKeyCode: %d was pressed",e.getKeyCode());
        if (e.getKeyCode() == 68) {
         player.move(1,0);   
        } 
        if (e.getKeyCode() == 65) {
        player.move(-1,0);
        }
        if (e.getKeyCode() == 87) {
        player.move(0,-1);
        }
        if (e.getKeyCode() == 83) {
        player.move(0,1);
    }
    }
   
    
     @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 68) {
         player.move(0,0);   
        } 
        if (e.getKeyCode() == 65) {
        player.move(0,0);
        }
        if (e.getKeyCode() == 87) {
        player.move(0,0);
        }
        if (e.getKeyCode() == 83) {
        player.move(0,0);
    }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.printf("\nMouse Clicked at (%d,%d)",e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}