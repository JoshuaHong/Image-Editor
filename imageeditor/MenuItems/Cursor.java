package imageeditor.MenuItems;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cursor extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Sets Menu Item Look And Feel
        cursor.setFocusPainted(true);
        cursor.setContentAreaFilled(true);
        paintbrush.setFocusPainted(false);
        paintbrush.setContentAreaFilled(false);
        eraser.setFocusPainted(false);
        eraser.setContentAreaFilled(false);
        eyeDropper.setFocusPainted(false);
        eyeDropper.setContentAreaFilled(false);
        cropper.setFocusPainted(false);
        cropper.setContentAreaFilled(false);
        
        //Disables Paintbrush, Eraser, and Eye Dropper
        paintbrushIsEnabled = false;
        eraserIsEnabled = false;
        eyeDropperIsEnabled = false;
        cropperIsEnabled = false;
        
        //Sets Original Cursor
        panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
}
