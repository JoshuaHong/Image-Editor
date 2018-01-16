package imageeditor.MenuItems;

import imageeditor.ImageEditor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Paintbrush extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Sets Menu Item Look And Feel
        paintbrush.setFocusPainted(true);
        paintbrush.setContentAreaFilled(true);
        eraser.setFocusPainted(false);
        eraser.setContentAreaFilled(false);
        eyeDropper.setFocusPainted(false);
        eyeDropper.setContentAreaFilled(false);
        cropper.setFocusPainted(false);
        cropper.setContentAreaFilled(false);
        cursor.setFocusPainted(false);
        cursor.setContentAreaFilled(false);
        
        //Enables Paintbrush, Disables Eraser and Eye Dropper
        paintbrushIsEnabled = true;
        eraserIsEnabled = false;
        eyeDropperIsEnabled = false;
        cropperIsEnabled = false;
        
        //Sets Paintbrush Cursor
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/imageeditor/Images/paintbrush.png").getImage(), new Point(0, 0), "paintbrush"));
    }
}
