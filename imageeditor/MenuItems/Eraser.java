package imageeditor.MenuItems;

import imageeditor.ImageEditor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Eraser extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        //Sets Menu Item Look And Feel
        eraser.setFocusPainted(true);
        eraser.setContentAreaFilled(true);
        eyeDropper.setFocusPainted(false);
        eyeDropper.setContentAreaFilled(false);
        cropper.setFocusPainted(false);
        cropper.setContentAreaFilled(false);
        cursor.setFocusPainted(false);
        cursor.setContentAreaFilled(false);
        paintbrush.setFocusPainted(false);
        paintbrush.setContentAreaFilled(false);

        //Enables Paintbrush, Disables Eraser and Eye Dropper
        eraserIsEnabled = true;
        paintbrushIsEnabled = false;
        eyeDropperIsEnabled = false;
        cropperIsEnabled = false;

        //Sets Eraser Cursor
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/imageeditor/Images/eraser.png").getImage(), new Point(0, 0), "eraser"));
    }
}
