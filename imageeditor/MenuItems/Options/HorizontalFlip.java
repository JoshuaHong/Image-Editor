package imageeditor.MenuItems.Options;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HorizontalFlip extends ImageEditor implements ActionListener {

    //Mirrors Position Of Pixels Horizontally
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int x = 0; x < image.getHeight(); x ++) {
            for (int y = 0; y < image.getWidth() / 2; y ++) {
                int rgb = image.getRGB(y, x);
                image.setRGB(y, x, image.getRGB(image.getWidth() - y - 1, x));
                image.setRGB(image.getWidth() - y - 1, x, rgb);
            }
        }
        draw();
    }
}
