package imageeditor.MenuItems.Options;

import imageeditor.ImageEditor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GaussianBlur extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                
                //Blurs Image by Bluring Surrounding Pixels
                if (x != 0 && y != 0 && y != image.getWidth() - 1 && x != image.getHeight() - 1) {
                    Color[] colour = new Color[9];
                    colour[0] = new Color(image.getRGB(y - 1, x - 1));
                    colour[1] = new Color(image.getRGB(y, x - 1));
                    colour[2] = new Color(image.getRGB(y + 1, x - 1));
                    colour[3] = new Color(image.getRGB(y - 1, x));
                    colour[4] = new Color(image.getRGB(y, x));
                    colour[5] = new Color(image.getRGB(y + 1, x));
                    colour[6] = new Color(image.getRGB(y - 1, x + 1));
                    colour[7] = new Color(image.getRGB(y, x + 1));
                    colour[8] = new Color(image.getRGB(y + 1, x + 1));
                    double finalR = 0, finalG = 0, finalB = 0;
                    
                    for (int i = 0; i < 9; i++) {
                        finalR += colour[i].getRed();
                        finalG += colour[i].getGreen();
                        finalB += colour[i].getBlue();
                    }
                    
                    finalR = finalR / 9;
                    finalG = finalG / 9;
                    finalB = finalB / 9;
                    
                    Color newColor = new Color((int) finalR, (int) finalG, (int) finalB);
                    image.setRGB(y, x, newColor.getRGB());
                }
            }
        }
        draw();
    }
}