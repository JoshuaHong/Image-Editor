package imageeditor.MenuItems.Options;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerticalFlip extends ImageEditor implements ActionListener {

    //Mirrors Position Of Pixels Horizontally
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int x = 0; x < image.getWidth(); x ++) {
            for (int y = 0; y < image.getHeight() / 2; y ++) {
                int rgb = image.getRGB(x, y);
                image.setRGB(x, y, image.getRGB(x, image.getHeight() - y - 1));
                image.setRGB(x, image.getHeight() - y - 1, rgb);
            }
        }
        draw();
    }
}
