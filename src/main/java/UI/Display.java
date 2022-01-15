package UI;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * The UI.Zoom is used to let user see the image that they are interested at in its original size
 *
 * @author  Shiyu Wang, Yurong Chen
 * @since   2021-12-05
 */

public class Display {

    public Display(Image image, String file_name) throws Exception {
        JFrame zoom = new JFrame();
        zoom.setLocation(500, 20);

        //get image size
        int w = image.getWidth(null);
        int h = image.getHeight(null);

        //get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;

        double scale;
        JPanel imagePanel = new JPanel();

        // scale image
        if (w <= h) {
            scale = screenHeight*0.85*1000/h; // calculate scale factor
            zoom.setTitle(file_name +"   Scale Factor: " + new DecimalFormat("0.00").format(scale/1000));
            Image scaled = image.getScaledInstance((int) ((w * scale)/1000), 800, Image.SCALE_DEFAULT);

            // display scaled image
            JLabel label = new JLabel(new ImageIcon(scaled));
            imagePanel.add(label);
        } else {
            scale = screenHeight*0.85*1000/w; //calculate scale factor
            zoom.setTitle(file_name +"   Scale Factor: " + new DecimalFormat("0.00").format(scale/1000));
            Image scaled = image.getScaledInstance(800, (int) ((h * scale)/1000), Image.SCALE_DEFAULT);

            // display scaled image
            JLabel label = new JLabel(new ImageIcon(scaled));
            imagePanel.add(label);
        }

        zoom.setLayout(new BorderLayout());
        zoom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        zoom.setVisible(true);
        zoom.add(imagePanel);
        zoom.pack();
    }
}
