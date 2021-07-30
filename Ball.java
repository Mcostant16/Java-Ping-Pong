import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics2D;
import java.lang.*;

public class Ball {
    private Dimension screenSize;
    private Color color;
    private Point location;
    private Point paddleLocation;
    private Point paddleLocation2;
    private int radius;
    private int diameter;
    private Point speed;

    public Ball(Dimension screenSize) {
        this.screenSize = screenSize;
        radius = ((int)15);
        diameter = radius * 2;
        location = new Point(screenSize.width/2,screenSize.height/2);
        this.color = Color.blue;
        speed = new Point((int)(7), (int)(7));
    }

    public int getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public Point getLocation() {
        return location;
    }

    public Point getSpeed() {
        return speed;
    }
    
    public void setUserPaddle1Location(Point paddleLocation){
        this.paddleLocation = paddleLocation;
    }    
    
    public void setUserPaddle2Location(Point paddleLocation){
        this.paddleLocation2 = paddleLocation;
    }   
    
    //moves the ball around and opposite of direction if contacts a paddle
    public void move() {
        location.setLocation(location.x+speed.x,location.y+speed.y);  
        if ( (location.x > screenSize.width-10-diameter && location.y+diameter > paddleLocation2.y && location.y < paddleLocation2.y+110) ||
             (location.x < 0+10 && location.y+diameter > paddleLocation.y && location.y < paddleLocation.y+110))
            speed.x = -(int)Math.round(speed.x*1.075);    
        if ( (location.y < 0) || (location.y > screenSize.height-diameter))
            speed.y = -speed.y; 
    }

    public void paintComponent(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(location.x, location.y, diameter, diameter);
    }
}
