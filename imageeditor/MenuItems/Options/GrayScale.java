package imageeditor.MenuItems.Options;

import imageeditor.ImageEditor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrayScale extends ImageEditor implements ActionListener {

    //Converts Pixels To Corresponding Gray Scale Value
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int x = 0; x < image.getHeight(); x ++) {
            for (int y = 0; y < image.getWidth(); y ++) {
                Color colour = new Color(image.getRGB(y, x));
                Color newColor = new Color((int) (colour.getRed() * 0.299 + colour.getGreen() * 0.587 + colour.getBlue() * 0.114), (int) (colour.getRed() * 0.299 + colour.getGreen() * 0.587 + colour.getBlue() * 0.114), (int) (colour.getRed() * 0.299 + colour.getGreen() * 0.587 + colour.getBlue() * 0.114));
                image.setRGB(y, x, newColor.getRGB());
            }
        }
        draw();
    }
}
