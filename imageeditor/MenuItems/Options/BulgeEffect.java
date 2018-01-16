package imageeditor.MenuItems.Options;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BulgeEffect extends ImageEditor implements ActionListener {

    private static final double K = 1.5;
    private static final double M = Math.log(1000000) * K;
    private int[][] temp = new int[1000][1000];

    @Override
    public void actionPerformed(ActionEvent e) {

        //Stores Pixels of Bulged Image in Array
        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                int xFinal = (int) (x - image.getHeight() / 2);
                int yFinal = (int) (y - image.getWidth() / 2);
                double newRadius = Math.pow(Math.sqrt(yFinal * yFinal + xFinal * xFinal), K) / M;
                double angle = Math.atan2(xFinal, yFinal);
                xFinal = (int) (newRadius * Math.sin(angle) + image.getHeight() / 2);
                yFinal = (int) (newRadius * Math.cos(angle) + image.getWidth() / 2);

                if (xFinal < image.getHeight() && xFinal > 0 && yFinal < image.getWidth() && yFinal > 0) {
                    temp[y][x] = image.getRGB(yFinal, xFinal);
                }
            }
        }
        
        //Draws New Image Based on Pixels in Array
        for (int x = 0; x < image.getHeight(); x ++) {
            for (int y = 0; y < image.getWidth(); y ++) {
                image.setRGB(y, x, temp[y][x]);
            }
        }
        
        draw();
        
        //Resets Pixels in Array
        temp = new int[1000][1000];
    }
}
