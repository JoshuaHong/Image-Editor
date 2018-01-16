package imageeditor.MenuItems;

import imageeditor.ImageEditor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Cropper extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        //Sets Menu Item Look And Feel
        cropper.setFocusPainted(true);
        cropper.setContentAreaFilled(true);
        eyeDropper.setFocusPainted(false);
        eyeDropper.setContentAreaFilled(false);
        cursor.setFocusPainted(false);
        cursor.setContentAreaFilled(false);
        paintbrush.setFocusPainted(false);
        paintbrush.setContentAreaFilled(false);
        eraser.setFocusPainted(false);
        eraser.setContentAreaFilled(false);

        //Enables Cropper, Disables Paintbrush, Eraser and Eye Dropper
        cropperIsEnabled = true;
        paintbrushIsEnabled = false;
        eraserIsEnabled = false;
        eyeDropperIsEnabled = false;

        //Sets Cropper Cursor
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/imageeditor/Images/cropper.png").getImage(), new Point(0, 0), "cropper"));
    }
}
