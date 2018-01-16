package imageeditor.MenuItems.Options;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Restore extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Initializes Initial Image File
            image = ImageIO.read(originalFile);
            draw();
        } catch (IOException ex) {
            Logger.getLogger(Restore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
