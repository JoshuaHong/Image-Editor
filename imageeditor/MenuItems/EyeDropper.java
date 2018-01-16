package imageeditor.MenuItems;

import imageeditor.ImageEditor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class EyeDropper extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Sets Menu Item Look And Feel
        eyeDropper.setFocusPainted(true);
        eyeDropper.setContentAreaFilled(true);
        cropper.setFocusPainted(false);
        cropper.setContentAreaFilled(false);
        cursor.setFocusPainted(false);
        cursor.setContentAreaFilled(false);
        paintbrush.setFocusPainted(false);
        paintbrush.setContentAreaFilled(false);
        eraser.setFocusPainted(false);
        eraser.setContentAreaFilled(false);
        
        //Enables Eye Dropper, Disables Paintbrush and Eraser
        eyeDropperIsEnabled = true;
        cropperIsEnabled = false;
        paintbrushIsEnabled = false;
        eraserIsEnabled = false;
        
        //Sets Eraser Cursor
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/imageeditor/Images/eyedropper.png").getImage(), new Point(0, 0), "eyeDropper"));
    }
}
