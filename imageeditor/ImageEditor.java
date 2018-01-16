package imageeditor;

import imageeditor.MenuItems.EyeDropper;
import imageeditor.Listeners.Mouse;
import imageeditor.Listeners.MouseMotion;
import imageeditor.Listeners.Slider;
import imageeditor.MenuItems.Cropper;
import imageeditor.MenuItems.Cursor;
import imageeditor.MenuItems.Eraser;
import imageeditor.MenuItems.Options.BulgeEffect;
import imageeditor.MenuItems.Options.GaussianBlur;
import imageeditor.MenuItems.Options.GrayScale;
import imageeditor.MenuItems.Options.HorizontalFlip;
import imageeditor.MenuItems.Options.InvertColour;
import imageeditor.MenuItems.Options.Restore;
import imageeditor.MenuItems.Options.SepiaTone;
import imageeditor.MenuItems.Options.VerticalFlip;
import imageeditor.MenuItems.File.Exit;
import imageeditor.MenuItems.File.Open;
import imageeditor.MenuItems.File.SaveAs;
import imageeditor.MenuItems.Help;
import imageeditor.MenuItems.Paintbrush;
import imageeditor.MenuItems.Tools.SetBackgroundColour;
import imageeditor.MenuItems.Tools.SetPaintbrushColour;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;

public class ImageEditor {

    //Initializes GUI Components
    protected static final JFrame frame = new JFrame("Image Editor GUI");
    protected static final JPanel panel = new JPanel();
    private static final JMenuBar menuBar = new JMenuBar();
    private static final JMenu file = new JMenu("File");
    private static final JMenu options = new JMenu("Options");
    protected static final JMenu tools = new JMenu("Tools");
    protected static final JButton cursor = new JButton();
    protected static final JButton paintbrush = new JButton();
    protected static final JButton eraser = new JButton();
    protected static final JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 20, 10);
    protected static final JLabel sliderLabel = new JLabel("Size: 10");
    protected static final JLabel blankLabel2 = new JLabel("     ");
    protected static final JButton eyeDropper = new JButton();
    protected static final JButton cropper = new JButton();
    protected static final JLabel blankLabel = new JLabel("                                                                                                                                                                                                                                ");
    protected static final JButton help = new JButton();
    protected static final JMenuItem open = new JMenuItem("Open");
    protected static final JMenuItem saveAs = new JMenuItem("Save As");
    private static final JMenuItem exit = new JMenuItem("Exit");
    protected static final JMenuItem restore = new JMenuItem("Restore to Original");
    protected static final JMenuItem horizontalFlip = new JMenuItem("Horizontal Flip");
    protected static final JMenuItem verticalFlip = new JMenuItem("Vertical Flip");
    protected static final JMenuItem grayScale = new JMenuItem("Gray Scale");
    protected static final JMenuItem sepiaTone = new JMenuItem("Sepia Tone");
    protected static final JMenuItem invertColour = new JMenuItem("Invert Colour");
    protected static final JMenuItem gaussianBlur = new JMenuItem("Gaussian Blur");
    protected static final JMenuItem bulgeEffect = new JMenuItem("Bulge Effect");
    protected static final JMenuItem setPaintbrushColour = new JMenuItem("Set Paintbrush Colour");
    protected static final JMenuItem setBackgroundColour = new JMenuItem("Set Background Colour");
    protected static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected static JLabel label = new JLabel("Please select an image!", JLabel.CENTER);
    protected static BufferedImage image;
    protected static File originalFile;
    protected static Color backgroundColour = Color.BLACK;
    protected static Color paintbrushColour = Color.BLUE;
    protected static boolean paintbrushIsEnabled = false;
    protected static boolean eraserIsEnabled = false;
    protected static boolean eyeDropperIsEnabled = false;
    protected static boolean cropperIsEnabled = false;
    protected static int basicStroke = 10;

    public static void main(String[] args) {

        //Adds GUI Components
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize((int) (screenSize.getWidth() * 0.8), (int) (screenSize.getHeight() * 0.8));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(options);
        menuBar.add(tools);
        menuBar.add(cursor);
        menuBar.add(paintbrush);
        menuBar.add(eraser);        
        menuBar.add(slider);
        menuBar.add(sliderLabel);
        menuBar.add(blankLabel2);
        menuBar.add(eyeDropper);
        menuBar.add(cropper);
        menuBar.add(blankLabel);
        menuBar.add(help);
        file.add(open);
        file.add(saveAs);
        file.addSeparator();
        file.add(exit);
        options.add(restore);
        options.addSeparator();
        options.add(horizontalFlip);
        options.add(verticalFlip);
        options.add(grayScale);
        options.add(sepiaTone);
        options.add(invertColour);
        options.add(gaussianBlur);
        options.add(bulgeEffect);
        tools.add(setBackgroundColour);
        tools.add(setPaintbrushColour);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);
        panel.add(label);
        label.setFont(new Font("Times New Romans", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        //Disables Menu Items Until Image Displayed
        saveAs.setEnabled(false);
        restore.setEnabled(false);
        horizontalFlip.setEnabled(false);
        verticalFlip.setEnabled(false);
        grayScale.setEnabled(false);
        sepiaTone.setEnabled(false);
        invertColour.setEnabled(false);
        gaussianBlur.setEnabled(false);
        bulgeEffect.setEnabled(false);
        eyeDropper.setEnabled(false);
        cropper.setEnabled(false);

        //Sets Menu Item Icons
        cursor.setIcon(new ImageIcon(new ImageIcon("src/imageeditor/Images/cursor.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        paintbrush.setIcon(new ImageIcon(new ImageIcon("src/imageeditor/Images/paintbrush.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        eraser.setIcon(new ImageIcon(new ImageIcon("src/imageeditor/Images/eraser.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        eyeDropper.setIcon(new ImageIcon(new ImageIcon("src/imageeditor/Images/eyedropper.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        cropper.setIcon(new ImageIcon(new ImageIcon("src/imageeditor/Images/cropper.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        help.setIcon(new ImageIcon(new ImageIcon("src/imageeditor/Images/help.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));

        //Sets Menu Item Look And Feel
        paintbrush.setFocusPainted(false);
        paintbrush.setContentAreaFilled(false);
        eraser.setFocusPainted(false);
        eraser.setContentAreaFilled(false);
        eyeDropper.setFocusPainted(false);
        eyeDropper.setContentAreaFilled(false);
        cropper.setFocusPainted(false);
        cropper.setContentAreaFilled(false);
        help.setFocusPainted(false);
        help.setContentAreaFilled(false);
        
        //Sets Menu Item Tooltip Texts
        cursor.setToolTipText("Cursor");
        paintbrush.setToolTipText("Paintbrush");
        eraser.setToolTipText("Eraser");
        eyeDropper.setToolTipText("Eyedropper");
        cropper.setToolTipText("Cropper");
        help.setToolTipText("Help");

        //Adds Menu Item Action Listeners
        open.addActionListener(new Open());
        saveAs.addActionListener(new SaveAs());
        exit.addActionListener(new Exit());
        restore.addActionListener(new Restore());
        horizontalFlip.addActionListener(new HorizontalFlip());
        verticalFlip.addActionListener(new VerticalFlip());
        grayScale.addActionListener(new GrayScale());
        sepiaTone.addActionListener(new SepiaTone());
        invertColour.addActionListener(new InvertColour());
        gaussianBlur.addActionListener(new GaussianBlur());
        bulgeEffect.addActionListener(new BulgeEffect());
        setPaintbrushColour.addActionListener(new SetPaintbrushColour());
        setBackgroundColour.addActionListener(new SetBackgroundColour());
        cursor.addActionListener(new Cursor());
        paintbrush.addActionListener(new Paintbrush());
        eraser.addActionListener(new Eraser());
        panel.addMouseListener(new Mouse());
        panel.addMouseMotionListener(new MouseMotion());
        slider.addChangeListener(new Slider());
        eyeDropper.addActionListener(new EyeDropper());
        cropper.addActionListener(new Cropper());
        help.addActionListener(new Help());

        //Sets Menu Item Shortcuts
        open.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        saveAs.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        exit.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        restore.setAccelerator(KeyStroke.getKeyStroke('R', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        horizontalFlip.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        verticalFlip.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        grayScale.setAccelerator(KeyStroke.getKeyStroke('G', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        sepiaTone.setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        invertColour.setAccelerator(KeyStroke.getKeyStroke('I', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        gaussianBlur.setAccelerator(KeyStroke.getKeyStroke('U', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        bulgeEffect.setAccelerator(KeyStroke.getKeyStroke('B', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        setPaintbrushColour.setAccelerator(KeyStroke.getKeyStroke('D', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        setBackgroundColour.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    }

    //Draws Updated Image
    protected void draw() {
        label = new JLabel(new ImageIcon(image));
        panel.removeAll();
        panel.add(label, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
}
