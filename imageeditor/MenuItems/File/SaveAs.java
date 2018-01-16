package imageeditor.MenuItems.File;

import imageeditor.ImageEditor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SaveAs extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Initializes File Chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/"));
        fileChooser.setDialogTitle("Save As");

        if (fileChooser.showSaveDialog(saveAs) == JFileChooser.APPROVE_OPTION) {
            File saveImage = new File(fileChooser.getSelectedFile().getAbsolutePath());

            try {
                //Saves Image File
                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics g = bufferedImage.getGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();

                //Override Existing File Option
                if (saveImage.exists()) {
                    int override = JOptionPane.showConfirmDialog(frame, "There is already a file with the same name in this location!\nOverride?", "Override?", JOptionPane.YES_NO_OPTION);
                    if (override == JOptionPane.YES_OPTION) {
                        ImageIO.write(bufferedImage, "jpg", saveImage);
                        JOptionPane.showMessageDialog(frame, "Save successful!");
                    }
                } else {
                    //Successful Save Confirmation
                    ImageIO.write(bufferedImage, "jpg", saveImage);
                    JOptionPane.showMessageDialog(frame, "Save successful!");
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(frame, "Please save a valid image!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}