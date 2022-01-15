package UI;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import javax.swing.*;
/**
 * The UI.Zoom is used to let user see the image that they are interested at in its original size
 *
 * @author  Shiyu Wang, Yurong Chen
 * @since   2021-12-05
 */
public class Display {
    private String fileName;
    private JFrame zoom = new JFrame();
    private JPanel imagePanel = new JPanel();

    public Display(Image image, String file_name) throws Exception {

        fileName = file_name;
        //zoom.setTitle(fileName);
        zoom.setLocation(500, 20);
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        //DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("w="+w);
        System.out.println("h="+h);
        double scale;
            if (w <= h) {
                scale = 800*1000/h;
                //Double result = df.format(scale);

                System.out.println("scale="+new DecimalFormat("0.00").format(scale/1000));
                zoom.setTitle(fileName+"   Scale Factor: " + new DecimalFormat("0.00").format(scale/1000));
                Image scaled = image.getScaledInstance((int) ((w * scale)/1000), 800, Image.SCALE_DEFAULT);
                System.out.println("scaled_w"+(w * scale)/1000);

                JLabel label = new JLabel(new ImageIcon(scaled));
                imagePanel.add(label);

            } else {
                scale = 800*1000/w;
                //System.out.println("scale="+scale);
                //System.out.println("scale="+new DecimalFormat("0.00").format(scale/1000));
                //zoom.setTitle(fileName+" Scaling factor: " + scale/1000);
                zoom.setTitle(fileName+"   Scale Factor: " + new DecimalFormat("0.00").format(scale/1000));
                Image scaled = image.getScaledInstance(800, (int) ((h * scale)/1000), Image.SCALE_DEFAULT);
                System.out.println("scaled_h"+(h * scale)/1000);
                JLabel label = new JLabel(new ImageIcon(scaled));
                imagePanel.add(label);
            }

        //zoom.setSize(new Dimension(image.getWidth(null)));

        zoom.setLayout(new BorderLayout());
        zoom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        zoom.setVisible(true);
        //JPanel imagePanel = init(image);
        //image.getScaledInstance(zoom.getWidth(), zoom.getHeight(), Image.SCALE_DEFAULT);
        //JLabel label = new JLabel(new ImageIcon(scaled));
        //imagePanel.add(label);
        zoom.add(imagePanel);
        zoom.pack();
/*
        zoom.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                image.getScaledInstance(zoom.getWidth(), zoom.getHeight(), Image.SCALE_DEFAULT);
                //JLabel label = new JLabel(new ImageIcon(newImage));
                //imagePanel.add(label);
            }
        });


    }
/*
    public JPanel init(Image image) throws Exception {
        /*
        int w = image.getWidth(null)*5;
        int h = image.getHeight(null)*5;


        zoom.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image newImage = image.getScaledInstance(zoom.getWidth(), zoom.getHeight(), Image.SCALE_DEFAULT);
                JLabel label = new JLabel(new ImageIcon(newImage));
                imagePanel.add(label);
            }
        });
        //Image newImage = image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
        //JLabel label = new JLabel(new ImageIcon(newImage));
        //JPanel imagePanel = new JPanel();
        //imagePanel.add(label);

        return imagePanel;

    }

    */

    }
}
