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
    private Border leftWall;
    private Border rightWall;
    private Border topWall;
    private Border bottomWall;
    private Enemy enemy1;
    private Enemy enemy2;
    private Goal finish;
    
    public HardestGame() {
        this.player = new Player(50,300);
        this.leftWall = new Border(0,0,25,600);
        this.rightWall = new Border(750,0,25,600);
        this.topWall = new Border(0,0,800,25);
        this.bottomWall = new Border(0,545,800,25);
        this.finish = new Goal(700,25,50,50);
        //this.enemy1 = new Enemy(50,25,50,50);
        //this.enemy2 = new Enemy(50,100,50,50);
        
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/60); //fps 12
    }
    
   
    
    private void checkCollisions() {
        if (enemy1.getX() == rightWall.getX()) {
            enemy1.hitsWall(enemy1);
        }
    }
    
    
    
     @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        frameCount++;
        
        
        this.setBackground(Color.WHITE);		
        this.enemy1 = new Enemy(frameCount,25,50,50);
        this.enemy2 = new Enemy(frameCount,100,50,50);
        checkCollisions();
        
        player.draw(g);	
        leftWall.draw(g);
        rightWall.draw(g);
        topWall.draw(g);
        bottomWall.draw(g);
        finish.draw(g);
        enemy1.draw(g);
        enemy2.draw(g);
        
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
        System.out.printf("\nKeyCode: %d was pressed",e.getKeyCode());
    }
    
     @Override
    public void keyReleased(KeyEvent e) {
        
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