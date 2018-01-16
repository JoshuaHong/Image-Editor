package imageeditor.MenuItems.File;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Open extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Initializes File Chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src/imageeditor/Images"));
        fileChooser.setDialogTitle("Open");

        if (fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
            originalFile = fileChooser.getSelectedFile();

            try {
                //Sets Initial Image
                image = ImageIO.read(originalFile);
                
                //Sets Image Dimension Bounds
                if (image.getWidth() < 1000 & image.getHeight() < 1000) {
                    draw();

                    //Enables Editing Menu Items
                    saveAs.setEnabled(true);
                    restore.setEnabled(true);
                    horizontalFlip.setEnabled(true);
                    verticalFlip.setEnabled(true);
                    grayScale.setEnabled(true);
                    sepiaTone.setEnabled(true);
                    invertColour.setEnabled(true);
                    gaussianBlur.setEnabled(true);
                    bulgeEffect.setEnabled(true);
                    eyeDropper.setEnabled(true);
                    cropper.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select an image smaller than 1000x1000!", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(frame, "Please select a valid image!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
