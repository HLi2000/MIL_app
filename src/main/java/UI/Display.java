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

    public Display(Image image, String file_name) {

        JFrame zoom = new JFrame();
        zoom.setLocation(500, 20);
        int w = image.getWidth(null);
        int h = image.getHeight(null);

        System.out.println("w="+w);
        System.out.println("h="+h);
        double scale;

        /*Scale the image to prevent the image is too large or too small to view */
        JPanel imagePanel = new JPanel();
        if (w <= h) {
            scale = 800.0*1000.0/h;

            System.out.println("scale="+new DecimalFormat("0.00").format(scale/1000));
            zoom.setTitle(file_name +"   Scale Factor: " + new DecimalFormat("0.00").format(scale/1000));
            Image scaled = image.getScaledInstance((int) ((w * scale)/1000), 800, Image.SCALE_DEFAULT);
            System.out.println("scaled_w"+(w * scale)/1000);

            JLabel label = new JLabel(new ImageIcon(scaled));
            imagePanel.add(label);

        } else {
            scale = 800.0*1000.0/w;
            zoom.setTitle(file_name +"   Scale Factor: " + new DecimalFormat("0.00").format(scale/1000));
            Image scaled = image.getScaledInstance(800, (int) ((h * scale)/1000), Image.SCALE_DEFAULT);
            System.out.println("scaled_h"+(h * scale)/1000);
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