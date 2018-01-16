package imageeditor.Listeners;

import imageeditor.ImageEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends ImageEditor implements ChangeListener {

    //Sets Value Of BasicStroke And Slider
    @Override
    public void stateChanged(ChangeEvent e) {
        basicStroke = slider.getValue();
        sliderLabel.setText("Size: " + basicStroke);
    }
}
