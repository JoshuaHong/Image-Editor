package imageeditor.Listeners;

import imageeditor.ImageEditor;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotion extends ImageEditor implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        
        //Paints Image With Set Colour
        if (paintbrushIsEnabled) {
            Graphics2D g = (Graphics2D) panel.getGraphics();
            g.setColor(paintbrushColour);
            g.setStroke(new BasicStroke(basicStroke));
            g.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
            g.dispose();
            
            //Erases Everything
        } else if (eraserIsEnabled) {
            Graphics2D g = (Graphics2D) panel.getGraphics();
            g.setColor(backgroundColour);
            g.setStroke(new BasicStroke(basicStroke));
            g.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
            g.dispose();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
