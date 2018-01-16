package imageeditor.MenuItems.Tools;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;

public class SetPaintbrushColour extends ImageEditor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        paintbrushColour = JColorChooser.showDialog(null, "Choose A Color!", paintbrushColour);
    }
}