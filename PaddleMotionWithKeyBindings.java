import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PaddleMotionWithKeyBindings
{
    private JComponent component;

    public PaddleMotionWithKeyBindings(JComponent component)
    {
        this.component = component;
    }

    //  Move the component to its new location. The component will stop
    //  moving when it reaches the bounds of its container

    public void move(int deltaX, int deltaY)
    {
        int componentWidth = component.getSize().width;
        int componentHeight = component.getSize().height;

        Dimension parentSize = component.getParent().getSize();
        int parentWidth  = parentSize.width;
        int parentHeight = parentSize.height;

        //  Determine next X position

        int nextX = Math.max(component.getLocation().x +deltaX, 0);
        
        if ( nextX + componentWidth > parentWidth)
        {
            nextX = parentWidth - componentWidth;
        }
        
        //  Determine next Y position

        int nextY = Math.max(component.getLocation().y +deltaY, 0);
        
        if ( nextY + componentHeight > parentHeight)
        {
            nextY = parentHeight - componentHeight;
        }
        
        //  Move the component

        component.setLocation(nextX, nextY);
    }
  
    public MotionAction addAction(String name, int deltaX, int deltaY)
    {
        MotionAction action = new MotionAction(name, deltaX, deltaY);

        KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(name);
        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(pressedKeyStroke, name);
        component.getActionMap().put(name, action);

        return action;
    }
    //This adds Action Listener and adds move Action when Ran...
    public class MotionAction extends AbstractAction implements ActionListener
    {
        private int deltaX;
        private int deltaY;

        public MotionAction(String name, int deltaX, int deltaY)
        {
            super(name);

            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public void actionPerformed(ActionEvent e)
        {
            move(deltaX, deltaY);
        }
    }

}
