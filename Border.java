
package hardestgame;


import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author 800215
 */
public class Border {
    private final int x,y,width,height;
    private final static Color COLOR = Color.BLACK;
    
    public Border(int x, int y,int width,int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
    }
    
    
    
    
    public void win(){
        
    }
    
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
}
