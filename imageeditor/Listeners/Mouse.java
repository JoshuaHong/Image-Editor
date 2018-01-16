package imageeditor.Listeners;

import imageeditor.ImageEditor;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Mouse extends ImageEditor implements MouseListener {

    private int x;
    private int y;
    private int x2;
    private int y2;
    private int tempx;
    private int tempy;
    
    //Gets Colour Of Clicked Pixel
    @Override
    public void mouseClicked(MouseEvent e) {
        if (eyeDropperIsEnabled) {
            try {
                Color color = new Color(image.getRGB(e.getX() - (panel.getWidth() - image.getWidth()) / 2, e.getY() - (panel.getHeight() - image.getHeight()) / 2));
                JOptionPane.showMessageDialog(frame, "Red: " + color.getRed() + "     Green: " + color.getGreen() + "     Blue: " + color.getBlue());
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(frame, "Please click on the image!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (cropperIsEnabled) {
            x = e.getX() - (panel.getWidth() - image.getWidth()) / 2;
            y = e.getY() - (panel.getHeight() - image.getHeight()) / 2;
            
            if (x < 0 | y < 0) {
                JOptionPane.showMessageDialog(frame, "Please click on the image!", "Warning!", JOptionPane.WARNING_MESSAGE);
                x = -1;
                y = -1;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (cropperIsEnabled) {
            x2 = e.getX() - (panel.getWidth() - image.getWidth()) / 2;
            y2 = e.getY() - (panel.getHeight() - image.getHeight()) / 2;
            
            if (x2 > image.getWidth() | y2 > image.getHeight()) {
                JOptionPane.showMessageDialog(frame, "Please release on the image!", "Warning!", JOptionPane.WARNING_MESSAGE);
                x = -1;
                y = -1;
            }
            if (x2 < x) {
                tempx = x;
                x = x2;
                x2 = tempx;
            }
            if (y2 < y) {
                tempy = y;
                y = y2;
                y2 = tempy;
            }
            
            try {
                image = image.getSubimage(x, y, x2 - x, y2 - y);
                draw();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(frame, "Please crop the image correctly!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
