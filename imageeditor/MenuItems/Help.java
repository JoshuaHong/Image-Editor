package imageeditor.MenuItems;

import imageeditor.ImageEditor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;

public class Help extends ImageEditor implements ActionListener {

    //Launches Support Website
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Desktop.getDesktop().open(new File("src/imageeditor/Docs/index.html"));
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, "Joshua Hong");
        }
    }
}
