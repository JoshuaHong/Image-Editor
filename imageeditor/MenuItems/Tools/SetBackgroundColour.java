package imageeditor.MenuItems.Tools;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;

public class SetBackgroundColour extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        backgroundColour = JColorChooser.showDialog(null, "Choose A Color!", backgroundColour);
        if (backgroundColour != null) {
            panel.setBackground(backgroundColour);
        }
    }
}
