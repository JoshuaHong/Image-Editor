package imageeditor.MenuItems.Options;

import imageeditor.ImageEditor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SepiaTone extends ImageEditor implements ActionListener {

    //Converts Pixels To Corresponding Sepia Tone Value
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int x = 0; x < image.getHeight(); x ++) {
            for (int y = 0; y < image.getWidth(); y ++) {
                Color colour = new Color(image.getRGB(y, x));
                int red = (int) (colour.getRed() * 0.393 + colour.getGreen() * 0.769 + colour.getBlue() * 0.189);
                int green = (int) (colour.getRed() * 0.349 + colour.getGreen() * 0.686 + colour.getBlue() * 0.168);
                int blue = (int) (colour.getRed() * 0.272 + colour.getGreen() * 0.534 + colour.getBlue() * 0.131);
                
                //Sets Colour Bounds
                if (red > 255) {
                    red = 255;
                }
                
                if (green > 255) {
                    green = 255;
                }
                
                if (blue > 255) {
                    blue = 255;
                }
                
                Color newColor = new Color(red, green, blue);
                image.setRGB(y, x, newColor.getRGB());
            }
        }
        draw();
    }
}
