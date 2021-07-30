import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;
public class UserPaddle {
    private Dimension screenSize;
    private Color color;
    private JComponent paddleComponent; // Paddle Component that goes in Panel
    
    public UserPaddle(Dimension screenSize) {
        this.screenSize = screenSize;
        paddleComponent = new JLabel( new ColorIcon(Color.RED, 10, 100) );
        paddleComponent.setSize( paddleComponent.getPreferredSize() ); //This code has to be here or the panel does not appear?
        paddleComponent.setLocation(0,screenSize.height/2);
    }

    // Getter
    public JComponent getComponent()   {
       return this.paddleComponent;
    }
    
    // Setter
    public void setPaddleComponent(JComponent newPaddleComponent) {
      this.paddleComponent = newPaddleComponent;
    }
    
    
       //public JComponent 
    
    
       public JButton addMotionSupport(JComponent component)
    {
        int delta = 50;
        PaddleMotionWithKeyBindings motion = new PaddleMotionWithKeyBindings(component);
        motion.addAction("Z", -delta,  0);
        motion.addAction("C",  delta,  0);
        motion.addAction("S",      0, -delta);
        motion.addAction("X",      0,  delta);

        Action left = component.getActionMap().get("LEFT");
        return new JButton(left);
    }
    
    static class ColorIcon implements Icon
    {
        private Color color;
        private int width;
        private int height;

        public ColorIcon(Color color, int width, int height)
        {
            this.color = color;
            this.width = width;
            this.height = height;
        }

        public int getIconWidth()
        {
            return width;
        }

        public int getIconHeight()
        {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    
    
    
    
}
