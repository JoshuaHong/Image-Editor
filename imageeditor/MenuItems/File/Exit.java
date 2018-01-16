package imageeditor.MenuItems.File;

import imageeditor.ImageEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit extends ImageEditor implements ActionListener {

    //Exits Program On Click
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}