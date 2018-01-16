package imageeditor.MenuItems.Options;

import imageeditor.ImageEditor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvertColour extends ImageEditor implements ActionListener {

    //Sets Opposite RGB Values Of Pixels
    @Override
    public void actionPerformed(ActionEvent e) {    
        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                Color colour = new Color(image.getRGB(y, x));
                colour = new Color(255 - colour.getRed(), 255 - colour.getGreen(), 255 - colour.getBlue());
                image.setRGB(y, x, colour.getRGB());
            }
        }
        draw();
    }
}
